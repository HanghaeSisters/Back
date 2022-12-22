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


</div>
</details>

<details>
<summary>2. 해당 게시글에서 작성한 댓글이 아님에도 댓글 아이디값만으로 모든 댓글의 수정이 가능했던 문제</summary>
<br>
<div markdown="2">
<b> ~~~ 방식으로 해결</b>  
<div class="colorscripter-code" style="color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important; position:relative !important;overflow:auto">
  <table class="colorscripter-code-table" style="margin:0;padding:0;border:none;background-color:#fafafa;border-radius:4px;" cellspacing="0" cellpadding="0">
    <tr>
      <td style="padding:6px;border-right:2px solid #e5e5e5">
        <div style="margin:0;padding:0;word-break:normal;text-align:right;color:#666;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%">
          <div style="line-height:130%">1</div>
          <div style="line-height:130%">2</div>
          <div style="line-height:130%">3</div>
          <div style="line-height:130%">4</div>
          <div style="line-height:130%">5</div>
          <div style="line-height:130%">6</div>
          <div style="line-height:130%">7</div>
          <div style="line-height:130%">8</div>
          <div style="line-height:130%">9</div>
          <div style="line-height:130%">10</div>
          <div style="line-height:130%">11</div>
          <div style="line-height:130%">12</div>
          <div style="line-height:130%">13</div>
          <div style="line-height:130%">14</div>
          <div style="line-height:130%">15</div>
          <div style="line-height:130%">16</div>
          <div style="line-height:130%">17</div>
          <div style="line-height:130%">18</div>
          <div style="line-height:130%">19</div>
          <div style="line-height:130%">20</div>
          <div style="line-height:130%">21</div>
          <div style="line-height:130%">22</div>
          <div style="line-height:130%">23</div>
          <div style="line-height:130%">24</div>
          <div style="line-height:130%">25</div>
          <div style="line-height:130%">26</div>
        </div></td><td style="padding:6px 0;text-align:left">
      
      <div style="margin:0;padding:0;color:#010101;font-family:Consolas, 'Liberation Mono', Menlo, Courier, monospace !important;line-height:130%">
        <div style="padding:0 6px; white-space:pre; line-height:130%">
          <span style="color:#999999">//&nbsp;수정&nbsp;전&nbsp;코드</span>
        </div>
        
        <div style="padding:0 6px; white-space:pre; line-height:130%">@DeleteMapping(<span style="color:#63a35c">"/posts/{postId}"</span>)</div><div style="padding:0 6px; white-space:pre; line-height:130%">
        <span style="color:#a71d5d">public</span>&nbsp;ResponseEntity<span style="color:#0086b3"></span>
        <span style="color:#a71d5d">&lt;</span>HttpStatus<span style="color:#0086b3"></span>
        <span style="color:#a71d5d">&gt;</span>&nbsp;postDelete(@PathVariable&nbsp;Long&nbsp;postId&nbsp;,&nbsp;</div>
        <div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@AuthenticationPrincipal&nbsp;UserDetailsImpl){</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">return</span>&nbsp;postService.delete(postId&nbsp;,&nbsp;user);</div><div style="padding:0 6px; white-space:pre; line-height:130%">}</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#999999">//&nbsp;수정&nbsp;후&nbsp;코드</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">@DeleteMapping(<span style="color:#63a35c">"/posts/{postId}"</span>)</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#a71d5d">public</span>&nbsp;ResponseEntity<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>HttpStatus<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;postDelete(@PathVariable&nbsp;Long&nbsp;postId&nbsp;,&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@RequestHeader(<span style="color:#63a35c">"Authorization"</span>)&nbsp;<span style="color:#066de2">String</span>&nbsp;user){</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">return</span>&nbsp;postService.delete(postId&nbsp;,&nbsp;user);</div><div style="padding:0 6px; white-space:pre; line-height:130%">}</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">@Transactional</div><div style="padding:0 6px; white-space:pre; line-height:130%"><span style="color:#a71d5d">public</span>&nbsp;ResponseEntity<span style="color:#0086b3"></span><span style="color:#a71d5d">&lt;</span>HttpStatus<span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;delete(Long&nbsp;postId,&nbsp;<span style="color:#066de2">String</span>&nbsp;user)&nbsp;{</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;Post&nbsp;post&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;postRepository.findById(postId).orElseThrow(</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;()&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">-</span><span style="color:#0086b3"></span><span style="color:#a71d5d">&gt;</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;NullPointerException(<span style="color:#63a35c">"찾으시는&nbsp;게시글이&nbsp;존재하지&nbsp;않습니다."</span>));</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999999">//&nbsp;토큰&nbsp;디코딩</span></div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#066de2">String</span>&nbsp;username&nbsp;<span style="color:#0086b3"></span><span style="color:#a71d5d">=</span>&nbsp;jwtDecoder.decodeUsername(user);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;validateCheckUser(username,&nbsp;post);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;postRepository.delete(post);</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;awsS3Service.deleteFile(post.getImageFilename());</div><div style="padding:0 6px; white-space:pre; line-height:130%">&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#a71d5d">return</span>&nbsp;<span style="color:#a71d5d">new</span>&nbsp;ResponseEntity(HttpStatus.OK);</div><div style="padding:0 6px; white-space:pre; line-height:130%">}</div></div><div style="text-align:right;margin-top:-13px;margin-right:5px;font-size:9px;font-style:italic"></div></td></tr></table></div>

</div>
</details>

<details>
<summary>3. 포스트에서 예외처리가 부족하여 모든 에러에 401 토큰 예외가 발생했던 문제</summary>
<br>
<div markdown="3">
<b> ~~~ 방식으로 해결</b>  


</div>
</details>

<details>
<summary>4. 거짓된 병원 정보를 입력할 수 있었던 문제</summary>
<br>
<div markdown="4">
<b> ~~~ 방식으로 해결</b>  


</div>
</details>
