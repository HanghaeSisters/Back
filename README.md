# 항해언니, Hanghae Sisters(Back-End)
> **성형에 대해 고민하고 있으신가요?**  
> 경험과 정보를 공유하고 고민을 덜어가세요!!

* [[Notion: 항해언니 프로젝트 정보]](https://www.notion.so/d2dffd18ee9d4d8e958185e288c08a2e)
* [[Front-End Repository]](https://github.com/HanghaeSisters/Front)  
  
## 📆 개발 기간  
2022년 12월 16일 ~ 2022년 12월 22일   
<p>

  
## 👯 팀원
**김규민(팀장)**  
<p>
  
[<img src="https://img.shields.io/badge/Github-181717?style=flat-square&logo=Github&logoColor=white">](https://github.com/starMinK)
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/>
</p>

**김소라**
<p>
  
[<img src="https://img.shields.io/badge/Github-181717?style=flat-square&logo=Github&logoColor=white">](https://github.com/dev-rara)
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/>
</p>

**정첨백**
<p>
  
[<img src="https://img.shields.io/badge/Github-181717?style=flat-square&logo=Github&logoColor=white">](https://github.com/civilcoy)
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/>
</p>  
  
## 🛠️ 기술 스택
  
|종류|기술|
|:----:|:----:|
|Language|<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white"/>|
|Build|<img src="https://img.shields.io/badge/Gralde-02303A?style=flat-square&logo=Gradle&logoColor=white"/>|
|FrameWork|<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/>|
|DB|<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/><br><img src="https://img.shields.io/badge/Amazon RDS-527FFF?style=flat-square&logo=Amazon RDS&logoColor=white"/>|
|Server|<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=flat-square&logo=Amazon EC2&logoColor=white"/>
  
## ERD
<img width="800" alt="메인페이지2" src="https://user-images.githubusercontent.com/65327103/209082821-ecdf919c-601a-4c36-b2d3-5d205b0414f6.png">

## 트러블 슈팅
<details>
<summary>1. 거짓된 병원 정보를 입력할 수 있었던 문제</summary>
<br>
<div markdown="1">
<b>오픈 api를 사용하여 전국의 병‧의원 중 진료과목에 성형외과가 있는 기관명을 받아와 조회하는 방식으로 해결</b>  
	
<b>1. 오픈 api로 전국의 병‧의원 중 진료과목에 성형외과가 있는 기관을 찾아 우리의 DB에 저장하기<b>
	
```java
	@Service
	@Slf4j
	@RequiredArgsConstructor
	@ToString
	public class HospitalService {

	    private final HospitalRepository hospitalRepository;

	    @Value("${hospital-url}")
	    private String hospitalUrl;

	    @Value("${hospital-key}")
	    private String hospitalKey;

	    private  Hospital getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nlList.item(0);
		if (nValue == null)
		    return null;
		return new Hospital(nValue.getNodeValue());
	    }

	    public void saveHospitalApiData(){
		try{
		    StringBuilder urlBuilder = new StringBuilder(hospitalUrl); /*URL*/
		    urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="+hospitalKey); /*Service Key*/
		    urlBuilder.append("&" + URLEncoder.encode("QD", "UTF-8") + "=" + URLEncoder.encode("D010", "UTF-8")); /*CODE_MST의'D000' 참조(D001~D029)*/
		    urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("4728", "UTF-8")); /*목록 건수*/
		    String url = urlBuilder.toString();

		    Document documentInfo = DocumentBuilderFactory
			    .newInstance()
			    .newDocumentBuilder()
			    .parse(url);

		    documentInfo.getDocumentElement().normalize();

		    NodeList nodeList = documentInfo.getElementsByTagName("item");

		    for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node node = nodeList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
			    Element element = (Element) node;

			    Hospital hospitalData = getTagValue("dutyName", element);
			    log.info(":::" + hospitalData + ":::");
			    hospitalRepository.save(hospitalData);
			}
		    }
		} catch(Exception e) {
		    e.printStackTrace();
		    log.error("hospital data not saved");
		    throw new CustomException(ErrorCode.FAILED_SAVE_DATA);
		}
	    }
	}
```  
								   
<b>2. 찾아온 데이터를 우리의 DB에 저장하기<b>  
		
```java
	@RestController
	@RequiredArgsConstructor
	public class HospitalController {

	    private final HospitalService hospitalService;

	    @PostMapping("/api/hospital/save-all")
	    public String HospitalApiSave() {
		return hospitalService.saveHospitalApiData();
	    }
	}
```  
	
<b>3. 조회한 병원이 존재하는지 확인하기</b>  
	
* Controller
	
```java
	@RequiredArgsConstructor
	@RestController
	@RequestMapping("/api/post")
	@Slf4j
	public class PostController {
		@GetMapping("/hospital")
		public MsgResponseDto checkHospital(@RequestParam("hospital-name") String hospitalName) {
		return postService.checkHospital(hospitalName);
		}
	}
```  
	
* Service
	
```java
	@Service
	@RequiredArgsConstructor
	@Slf4j
	@Transactional
	public class PostService {
		private final HospitalRepository hospitalRepository;

		private void hospitalNameValidation(String hospitalName) {
			boolean name_check = Pattern.matches("^[가-힣|0-9|a-z|A-Z]+$", hospitalName);
			if(!name_check) throw new CustomException(ErrorCode.VALIDATION_NOT_APPROPRIATE);
		}
	
		@Transactional(readOnly = true)
		public MsgResponseDto checkHospital(String hospitalName) {
			hospitalNameValidation(hospitalName);

			if (hospitalRepository.findByHospitalName(hospitalName).size() == 0) {
		  	  return new MsgResponseDto("존재하지 않는 병원입니다.", HttpStatus.BAD_REQUEST.value());
			}else{
			    return new MsgResponseDto("존재하는 병원입니다.", HttpStatus.OK.value());
			}
		}
	}
```
</div>
</details>

<details>
<summary>2. 해당 게시글에서 작성한 댓글이 아님에도 댓글 아이디값만으로 모든 댓글의 수정이 가능했던 문제</summary>
<div markdown="2">
<b>게시글과 댓글의 존재 여부는 확인했으나 해당 댓글이 그 게시글에 등록된 댓글인지 확인지 않았기 때문에 발생한 문제로, 댓글이 가진 게시글ID가 해당 게시글의 ID와 같은지 확인 하는 코드를 추가하여 해결</b> 

```java
//추가한 코드
if (!comment.getPostId().equals(postId)) {
	throw new CustomException(ErrorCode.MISMATCH_COMMENT);
}
``` 


</div>
</details>

<details>
<summary>3. 포스트에서 예외처리가 부족하여 모든 에러에 401 토큰 예외가 발생했던 문제</summary>
<br>
<div markdown="3">
<b>requestbody에서 값이 들어오지 않았을때의 예외 처리가 부족하여 PostDto에 @NotBalnk를 추가하는 방식으로 해결</b>  
	
<b>수정 전 코드</b>  
	
  ```java
  @Getter
  public class PostRequestDto {
    private String title;
    private String category;
    private String imageBefore;
    private String imageAfter;
    private String content;
    private int price;
    private String hospitalAddress;
    private String doctor;
  }
  ```
  
  <b>수정 후 코드</b>  
   ```java
  public class PostDto {

	public record RequestDto(@NotBlank(message = "제목이 입력되지 않았습니다.") String title,
							 @NotBlank(message = "카테고리가 입력되지 않았습니다.") String category,
							 @NotBlank(message = "성형 전 이미지가 필요합니다.") String imageBefore,
							 @NotBlank(message = "성형 후 이미지가 필요합니다.") String imageAfter,
							 @NotBlank(message = "본문 내용이 입력되지 않았습니다.") String content,
							 @NotNull(message = "금액이 입력되지 않았습니다.") Integer price,
							 @NotBlank(message = "병원 주소가 입력되지 않았습니다.") String hospitalAddress,
							 @NotBlank(message = "의사 정보가 입력되지 않았습니다.") String doctor) {
	  }
  }
  ```

</div>
</details>

<details>
<summary>4. 거짓된 병원 정보를 입력할 수 있었던 문제</summary>
<br>
<div markdown="4">
<b> ~~~ 방식으로 해결</b>  
  
```java
  function square(n) {
  return n * n;
}
```

</div>
</details>
