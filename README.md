# searchHouse
(jsp, servlet와 mysql을 사용한 회원 관리 및 집 검색 사이트)

#### ⭐원본 파일은 올릴 수 없어 수정하며 공부한 코드를 올렸습니다⭐

### 어려웠던 부분
- <b>도시를 선택하면 해당 도시의 '구'나 '군'만 골라 나오고, '구/군 고르면 해당 '구/군'의 '동'이 새로고침 없이 나오게 하는 부분</b>
  - fetch(), 비동기 통신
  - 팀원(@junhyxxn)과 같이 고민한 부분
  - 맡은 부분이 아니라서 단지 고민만 같이 했던 이 아쉬워 해당 프로젝트를 바탕으로 새로 코드를 짜며 복습했습니다.

### 담당
- 회원 관리(마이페이지), 게시판 관리, 로그인/로그아웃/회원탈퇴
  - 아파트 매매 부분을 맡고 싶었지만, 코로나 확진으로 인해 팀원이 먼저 아파트 매매 데이터를 접하게 되었고 따라서 팀원이 맡는 것이 효율적이라 판단하여 상의하에 진행되었습니다.
- 팀원(@junhyxxn) : 아파트 매매 검색

-- 10.12월 노트 추가 --
### 알고리즘 추가 (@kosy318, @2hojune)
1. 검색 시 LCS 사용 (아이디어 : @kosy318) - <b>구현 : @kosy318</b>
  - 띄어쓰기를 구분으로 단어 사이에 다른 단어가 있어도 검색되게끔 구현
  - 50퍼 이상 일치하면 단어 몇가지가 빠져도 검색되게끔 구현
  - <b>search 페이지 수정 필요, controller와 jsp에서 동 검색과 아파트 이름 검색 기능을 합치기</b>
  - <b>전체 아파트에서 찾기엔 시간이 오래 걸림, 선택한 동 내에서 검색하기</b>
2. 도서관과 아파트간 거리를 비교하여 가까운 아파트 top 5 또는 10 구하기 (아이디어 : @kosy318, @2hojune) - <b>구현 : @2hojune</b>
(도서관 데이터 추가 필요, 새로운 페이지 구현 필요)
  - dijkstra 사용(priority queue 사용)
3. 
