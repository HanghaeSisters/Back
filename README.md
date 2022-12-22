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
<b> ~~~ 방식으로 해결</b>  
  
```java
  System.oyt.println("asd");
```

</div>
</details>

<details>
<summary>2. 해당 게시글에서 작성한 댓글이 아님에도 댓글 아이디값만으로 모든 댓글의 수정이 가능했던 문제</summary>
<br>
<div markdown="2">
<b> ~~~ 방식으로 해결</b>

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
