# **KorCham**
상공회의소 자격증 자리확인 매크로

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/97077759-40185380-1621-11eb-97a6-4e8a17366284.png" width="600px" alt="NewCharm" title="NewCharm">
</p>

<p align="center">
	<b>위 프로그램은 테스트 목적으로 제작되었으며, 불특정 다수에게 배포되지 않습니다.</b>
</p>
<br />

상공회의소의 보안조치로 Korcham은 이제 동작이 전혀 불가능하다. 상시시험 페이지에만 보안을 잔뜩걸어놨더라. 이왕 걸어놓을거 다 걸어놓지 않는게 웃기지만. 이왕 붙인거 reChaptcha는 로그인에다도 붙이길 바란다.

내 나름의 공부 수준도 확인해보고 싶고, 예전부터 UI가 없는 프로그램이였던게 마음에 걸렸었다. 요즘 공부하는 C#의 Mahapps를 적극 활용하여 NewCham을 만들었다. 동작은 이상없이 잘 되는 것 같다. 이젠 코로나 여파도 많이 줄어 자리도 많은 것 같아 굳이 필요없게 된 것 같다.

보안을 위해서 NewCham의 프로그램과 소스는 비공개로 관리한다.

<br />
<br />
<br />
<br />

---

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88394919-34877780-cdfb-11ea-9601-3e583e6babb0.png" alt="Main" title="Main">
</p>

<p align="center">
	<b>현재 소스로 컴파일된 Korcham은 더이상 동작하지 않습니다.</b>
</p>
<br />

<p align="center">
	<a href="https://github.com/RWB0104/KorCham/releases"><del>다운로드</del></a>
</p>

<p align="center">
	<a href="https://github.com/RWB0104/KorCham/issues/2">질문하기</a>
</p>

<br />

2월 끝자락에 공부를 마무리하고 시험을 보려고 했으나, COVID-19의 여파로 시험이 14일까지 중지되는 바람에 가뜩이나 없는 자리가 몰려서 자리를 구할 수가 없게됐다.
<br />
회사에서 하루 종일 자격증 자리만 쳐다볼 수도 없는 노릇이고, 일일히 들어가기도 귀찮은데다, 까먹는 일도 더러 있어서 자리 잡기가 난감했다.
<br />
이미 다 끝낸 공부임에도 지속적으로 기억하기 위해 계속 붙잡고 있는게 너무 싫어서 최대한 빨리 자리를 잡을 필요가 있었다.
<br />
이 프로그램은 그러한 취지에서 개발됐다.

## **NewCharm 1.0 RELEASE (Latest, Not Published)**

+ UI 추가
+ 데이터 호출 로직 개선
+ 프로그램 내부에서의 능동적인 설정 가능

해당 프로그램은 배포되지 않습니다.

## **KorCham 3.3 RELEASE**

+ 시작일, 종료일 기능 개선
+ 설정파일 확인(2번 메뉴) 실행 시 설정값 자동 반영 기능 추가

앞으로는 start와 end를 통해 원하는 구간만을 지정하여 확인 가능합니다.

## **KorCham 3.2 RELEASE**

+ 크롤링 문제 수정

## **KorCham 3.1 RELEASE**

+ 설정파일 한글 깨짐 수정

+ 프로그램 오류 발생 시, 5초 대기 후 종료되도록 수정

+ 릴리즈 파일에 JRE 포함

## **KorCham 3.0 RELEASE**

+ 상공회의소 상시시험 자격증 전체 공식 지원 (2020.07.24 기준)
	+ 워드프로세서 전체
	+ 컴퓨터활용능력 전체
	+ 전산회계운용사 전체
	+ IT PLUS 전체
	+ 상공회의소 한자 전체

+ KorCham 프로그램 기능설명 변경
	+ 컴퓨터 활용능력 자격증 자리확인 매크로 -> 상공회의소 자격증 자리확인 매크로

+ JRE 1.8를 포함한 EXE 실행파일 추가 (Only Windows)

+ 사용자 메뉴 UI 추가

+ 시험, 등급, 지역별 URL 제공 기능 추가

+ 설정파일 내용 확인 기능 추가

+ 설정파일 날짜 표기 방식 완화

+ 사운드 다운로드 및 재생 관련 버그 수정

+ 내부 로직 처리시간 계산 관련 버그 수정

## KorCham 2.4 RELEASE

+ 간단한 프로그램 구동을 위한 cmd, sh, bash 파일 추가

+ 시간이 1000ms를 넘어갈 시 단위가 s로 변경되도록 개선

## KorCham 2.3 RELEASE

+ 설정 파일에 지정된 사운드 경로에 사운드 파일이 없을 경우 사용자의 선택에 따라 사운드 파일을 다운로드 받을 수 있도록 개선

## KorCham 2.2 RELEASE

+ URL연결 시간 및 데이터 처리 시간 출력기능 추가

+ KorChamConf.json 파일이 없을 경우 자동으로 기본 설정값을 가진 json파일이 생성되도록 개선

## KorCham 2.1 RELEASE

+ 좌석 발생 시 사운드 출력 기능 추가

+ 설정 파일에서 관련 설정이 가능하도록 개선

## KorCham 2.0 RELEASE

+ KorChamConf.json을 통한 URL, 날짜 지정기능 추가

## KorCham 1.0 RELEASE

+ 컴퓨터 활용능력 1급 서울 상공회의소 제 3 ~ 5시험장의 3월 18일까지의 좌석 수 출력

# **INFO**

개발언어 : `JAVA`

#### **지원 OS**
+ Microsoft **Windows10**
+ AIX
+ CentOS
+ 기타 JVM 구동 가능한 디바이스

#### **JAVA VERSION**
+ **JDK 1.8**

---
### **사용 방법**
컴파일 결과물은 **.jar**파일이며, 해당 파일을 실행하면 자동으로 설정파일의 내용대로 지정된 날짜까지의 좌석을 탐지하고 출력한다.
<br />
좌석이 없을 경우 별도의 내용이 출력되지 않으며, 좌석이 하나 이상 있을 경우 URL의 순번과 날짜, 시간, 좌석 수를 출력한다.
<br />

프로그램 시작 방법은 기본적인 JAVA 명령어를 사용하거나, Shell 파일을 실행해서 구동할 수 있다.
<br />
3.0 RELEASE 이후 추가된 EXE 실행파일을 실행하여 사용이 가능하다. EXE 파일의 경우 JRE이 포함되어 있어 별도의 사전작업을 요구하지 않는다.
<br />
<br />

**EXE 파일 실행** (Only Windows) : KorCham.exe 파일을 실행한다.
<br />

**JAVA 명령어 실행** : cmd 혹은 PowerShell을 키고 KorCham.jar가 위치한 폴더로 이동해서 `java -jar KorCham.jar` 명령어를 실행한다.
<br />

**start.cmd** : Windows OS용 Shell 프로그램으로, 해당 Shell을 실행하면 자동으로 프로그램이 실행된다.
<br />

**start.sh** : sh계열 Terminal용 Shell 프로그램으로, 해당 Shell을 실행하면 자동으로 프로그램이 실행된다. CLI 환경에서의 실행방법은 `./start.sh` 명령어를 입력하면 된다.
<br />

**start.bash** : bash계열 Terminal용 Shell 프로그램으로, 해당 Shell을 실행하면 자동으로 프로그램이 실행된다. CLI 환경에서의 실행방법은 `./start.bash` 명령어를 입력하면 된다.
<br />

**KorChamConf.json** 설정파일을 통해 프로그램의 세부 사항을 지정할 수 있다. 좌석을 검사할 대상의 URL은 JSON Array을 통해 여러개의 URL을 지정할 수 있으며, URL별로 날짜 또한 개별적으로 지정할 수 있다.
<br />
그 밖에도 로그의 경로나 사운드파일의 경로, 기능 사용 여부를 지정할 수 있다.
<br />

자세한 설정파일 사용 방법은 아래의 **설정방법** 문단을 확인한다.

---
### **설정방법**

KorCham이 실행되면 KorCham.jar 위치에 설정파일이 존재하는지 여부를 확인하고, 없을 경우 KorChamConf.json을 생성한다.
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/78545134-3c181600-7836-11ea-8261-88e19f69e923.png" alt="Main" title="Main">
</p>

<h2>JSON 설정파일의 형식을 유지해야 한다.</h2>

KorChamConf.json의 형태는 위 사진과 같으며, 설정방법은 아래와 같다.
<br />
<br />

**logPath** : 로그파일 저장 경로 (기본값: %KorCham.jar위치%\\logs\\yyyy-MM-dd hh-mm-ss.log)
<br />

**soundFile** : .wav파일 경로 (기본값: %KorCham.jar위치%\\sound\\alert.wav)
<br />

**logActive** : 로그기능 사용 여부 (기본값 : true)
<br />
true : 로그 기능 사용
<br />
false: 로그 기능 미사용
<br />

**soundActive** : 사운드 기능 사용 여부 (기본값 : true)
<br />
true : 사운드 기능 사용
<br />
false : 사운드 기능 미사용
<br />

**urlList** : 좌석을 감시할 URL 배열
<br />
**url** : URL (기본값 : 컴퓨터 활용능력 1급 서울 상공회의소(남대문) 제 3 ~ 5시험장)
<br />
<del>시험장 확인 URL은 사용자에게 숨겨져 있어서 Fiddler와 같은 프로그램을 이용해 Request를 받아서 따와야 한다.</del>
<br />
3.0 기준 시험, 등급, 지역별 URL를 제공하는 기능이 추가됐다.
<br />

**start** : 좌석을 검사할 시작 날짜 (기본값 : 오늘)
<br />
[yyyy.mm.dd]나 [yyyy. mm. dd] 형태로 입력하면, 해당 날짜 이후부터만 검사한다. 만약 빈칸으로 놔둘 경우 시험 응시가 가능한 가장 빠른날부터 자동으로 검사한다.
<br />

**end** : 좌석을 검사할 마지막 날짜 (기본값 : 최초로 KorChamConf.json 생성일자의 15일 이후)
<br />
[yyyy.mm.dd]나 [yyyy. mm. dd] 형태로 입력하면, 해당 날짜까지만 검사한다. 만약 빈칸으로 놔둘 경우 시험 응시가 가능한 가장 마지막날까지 자동으로 검사한다.
<br />

start와 end 둘 다 빈칸으로 두면 **전체 리스트를 검사한다.**
<br />

urlList의 경우, 배열형태로 이루어져 있어 여러 URL을 등록해서 감시할 수 있다.
<br />
물론 URL의 개수가 많아질 수록 프로그램의 루틴이 점점 길어진다.
<br />
<br />

**\\를 이용한 경로는 반드시 \\\\처럼 두번 입력해야 인식이 가능하니 주의**

---
### **세부 사항**
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395104-7dd7c700-cdfb-11ea-9f78-5c19a2ba84ba.png" alt="Main" title="Main">
</p>

첫 실행 시, 로그 폴더가 없을 경우 로그 폴더를 생성하고 기록
<br />
실행하면 위와같이 세 가지 메뉴 선택 가능
<br />
정해진 메뉴의 숫자를 입력하여 메뉴 선택
<br />
<br />

**1. 매크로 실행**
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395192-a52e9400-cdfb-11ea-85bd-9dc4398877f1.png" alt="Main" title="Main">
</p>
<br />

알람용 사운드 파일이 없을 경우 서버에서 기본적인 사운드 파일을 다운로드.
<br />
사용자의 판단에 따라 다운로드 가능
<br />
사운드 파일이 없어도 동작에는 이상이 없으며, 알람은 울리지 않음
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395222-b081bf80-cdfb-11ea-869c-498798b24021.png" alt="Main" title="Main">
</p>

<br />
자리가 있을 경우 위와 같이 지정된 시험장의 시험 날짜, 시간, 좌석 수를 표시하며, 이를 하나의 루틴이라 명명
<br />
자리가 감지되면 설정파일에 지정한 알람이 출력됨
<br />
URL이 여러개일 경우 URL1, URL2, URL3, ~ , URLn으로 표시함
<br />
설정파일에서 지정할 수 있는 URL의 갯수에는 제한이 없으나, URL이 많으면 많을 수록 한 루틴을 처리하는 시간이 길어짐
<br />
<br />

**2. 설정 확인**
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395273-c5f6e980-cdfb-11ea-92b4-b2c07f5deab2.png" alt="Main" title="Main">
</p>
<br />

설정파일에 입력한 내용을 확인할 수 있으며, 프로그램은 이 메뉴에서 표시하는 값을 기준으로 동작함.
<br />
해당 기능에서 사운드 테스트를 진행하는데, 지정한 경로에 사운드파일이 감지되지 않을 경우 기본 사운드 파일 다운로드 유무를 묻는다.
<br />
<br />

**3. 시험장 URL 리스트 출력**
<br />
<br />

아마 대다수의 사용자에게 가장 필요할 것 같은 기능
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395321-d60ec900-cdfb-11ea-9e81-d530144a0cbb.png" alt="Main" title="Main">
</p>
<br />

원하는 시험의 종류, 급수, 지역을 선택하면, 해당하는 시험장의 정보를 사용자에게 제공함.
<br />
공식적으로 지원하는 시험은 상공회의소에서 진행하는 상시시험 전체
<br />
원하는 시험의 번호를 선택하여 진행
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395338-ddce6d80-cdfb-11ea-95b8-d28188b1808b.png" alt="Main" title="Main">
</p>
<br />

시험을 선택하면, 해당하는 시험의 급수를 선택할 수 있다.
<br />
원하는 급수를 선택하여 진행
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395352-e757d580-cdfb-11ea-9123-66748f3c7d1c.png" alt="Main" title="Main">
</p>
<br />

해당 시험을 볼 수 있는 지역을 선택할 수 있다.
<br />
원하는 지역을 선택하여 URL을 제공받을 수 있다.
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395507-2a19ad80-cdfc-11ea-8662-91d70dfa2556.png" alt="Main" title="Main">
</p>
<br />

위와 같이 `.txt` 형태로 저장되며, 프로그램의 위치에 `url` 폴더를 생성하고 URL이 담긴 파일을 생성함.
<br />
<br />

<p align="center">
	<img src="https://user-images.githubusercontent.com/50317129/88395609-4f0e2080-cdfc-11ea-99dc-0ceaff5ed6b1.png" alt="Main" title="Main">
</p>
<br />

URL은 위 사진과 같이 저장되며, 순서대로 시험장 이름, 시험장 URL, 전화번호, 시험장 위치 지도 URL을 기록함.
<br />
<h2>URL 리스트의 두 번째 항목인 http://license.korcham.net/로 시작하는 URL이 시험장 URL이다.</h2>
원하는 시험장의 URL을 복사하고, 이를 설정파일에 양식에 맞춰 기록하면 된다.

---
### **주의사항**

실행 시 JDK가 1.8 이상인지 확인할 것.
<br />
단 **EXE 파일을 통한 실행 시 JRE가 포함**되므로 신경쓸 필요 없음.
<br />

Windows OS의 경우 경로가 (\\, 역슬래쉬)로 표시되는데, json 파일에서 이러한 역슬래쉬를 표시하려면 \\를 두번 입력해야 정상적으로 json에서 표시할 수 있다.
<br />
즉, 실제 경로가 `C:\Program Files`라면, json 파일에는 `C:\\Program Files`라고 입력해야 정상적으로 인식이 가능하다.
<br />
이는 프로그래밍에서 \\가 다른 알파벳과 결합하여 ASCII와 같은 특수문자를 매칭해 표현하는데 사용되기 때문으로, 프로그래밍 상의 한계라 어쩔 수 없다.

---
### **여담**

해당 프로그램을 사용하여 꽤나 타이트한 자리싸움에서 가장 빠른 3월 15일에 신청을 성공했다.
<br />
...는 COVID-19의 무지막지한 기승으로 밀리게 되고, 다시 가장 빠른 23일에 신청했다.
<br />
....는 또 밀려서 다시금 가장 빠른 4월 5일에 신청에 성공했고, 무사히 시험을 볼 수 있었다.
<br />

무려 두 번이나 밀렸음에도 악착같이 가장 빠른 시간대에 잡았던 것으로 보아 확실히 무작정 들어가서 자리를 확인하는 것 보다 효율적이였다. 사용하기 전 보다 확실히 차이가 남을 쓰면서 체감했다.
<br />
<br />

어찌보면 자리 싸움에서 우위를 차지하므로 부정행위라는 생각도 해봤는데, 공연 티켓팅 프로그램마냥 자동적으로 자리를 잡아주는 것도 아니고, 단순히 자리의 갯수만을 알려주는데서 그친다.
<br />
즉, 프로그램이 암만 알려줘도 실제로 자리를 차지하는 건 손싸움. 실제로도 괜찮은 자리를 놓쳤던 경험이 몇 번 있었다.
<br />
또한 나처럼 업무 자체가 컴퓨터로 뭘 하는 게 아니라면 결국 의미가 없어져버리는 셈. 애플리케이션 개발에 대한 지식이 조금 있으면 간단한 통신을 통한 PUSH알림 형태의 앱을 만들어볼까 생각도 했는데, 어차피 나만 쓸 거 같고, 간단한 애플리케이션이라도 직접 만드는 건 또 다른 느낌이라서 보류.
<br />
만약 이 프로그램이 정말 인기가 많아진다면 한 번 시도해보는 것도 나쁘지 않을 것 같다.
<br />

통상 3개의 서울 URL을 돌리는데 한 4초 정도 걸리는데, 설정파일 추가 이후 갑자기 한 사이클 당 8초로 늘어난 적이 있었다.
<br />
설정파일의 문제인가 싶어 구 버전의 프로그램을 돌려봐도 마찬가지. 다른 PC에서도 같은 현상이 일어났다.
<br />
이를 확인하기 위해 접속 시간과 데이터 처리 시간을 나누어 표시해봤으나, 접속 시간이 99% 이상을 차지했다. 설정파일이 추가되면서 이에 따른 데이터 처리 비용의 증가 가능성을 염두에 두었지만, JAVA는 내 생각보다 훨씬 빨랐다.
<br />
로그를 확인해보니, 새벽 시간에 URL접속이 정상적으로 이루어지지 않았고, 다시 접속이 재개된 이후 8초로 늘어남을 확인. 프로그램이 아닌 서버의 문제로 보여진다.
<br />
실제로 해당 URL의 HTML 페이지를 따서 테스트로 톰캣에 올려봤는데, 한 사이클 당 7ms만에 처리가 이루어지는 것을 확인했다. 물론 이 페이지는 DB를 읽는 등의 내부 로직이 없는 단순 HTML 코드이므로 매우 빠를 수 밖에.
<br />
결론적으로 해당 프로그램에서 한 사이클의 처리 속도는 전적으로 서버의 접속 속도에 따라 달라진다.
<br />
프로그램엔 총 처리 시간만 표출됐지만, 이 문제로 인해 접속시간과 처리시간을 나누어 표시하게 됐다.
<br />

프로그램의 구조 상 다른 자격증이나, 공연이나 기타 상품의 재고량 등이 HTML 테이블 및 &lt;tr&gt;, &lt;td&gt; 형태로 제공되는 경우, 해당 테이블의 id나 class값을 확인해서 소스코드만 바꿔주면 다른 식으로도 응용이 가능하다. 물론 HTML의 구조나 표현 방식에 따른 디테일은 알아서 신경써줘야 할 여지가 있다.
<br />
특히 상공회의소에 최적화되어있기 때문에 워드프로세서 등 다른 상공회의소 자격시험 응시 시, URL만 제대로 입력해주면 원만하게 사용이 가능하다.
<br />

개발 당시 3월 15일 시험이 아직 밀리지 않았었고, 이미 프로토타입 구동 시에 원하는 자리를 잡은 덕택에 사용 시간보다 개발 시간이 더 많았을 뻔 했으나, COVID-19의 영향으로 지속적으로 밀리면서 진가를 발휘한 프로그램
<br />

어차피 며칠만 쓸 프로그램이라 생각하고 개발한거라 설정 파일의 내용들은 원래 하드코딩되어 있었으나, 지속적인 일정 연기와 회사의 단축근무로 인해 여유가 많아져 프로그램의 많은 부분들을 개선할 수 있었다.
<br />
어찌보면 COVID-19는 이 프로그램이 발전할 수 있었던 원동력(?)이 된 셈이다.
<br />

<hr />

재미삼아 이곳저곳에 배포하고 잊고 있었는데, 문득 생각나서 확인해보니 생각보다 몇몇 사람들이 유용하게 쓰고있는 것 같아서 기쁘다.
<br />
대부분 JAVA 설치의 생소함과 URL 확인의 어려움을 겪고있는 것 같아 RELEASE 3.0에서 이를 대폭 개선했다.
<br />
프로그램을 만드는 것과 실사용자 배포는 또 다른 일이라는 것을 체감했다.
<br />
애초에 귀찮아서 잠깐 쓰려고 시작한 프로그램이라 여기저기 배포하고 다니긴 좀 그렇지만, 이왕 만든거 많은 사람들이 썼으면 좋겠다.
