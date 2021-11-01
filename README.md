# 이 프로젝트는 HTTP2, SSL을 설정하는 것을 익히고, 기록하는 프로젝트 입니다.


## SSL 인증서 생성하기
- keytool -genkey -alias sseob -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 4000

## SSL 설정후 확인하기.

- SSL 설정후 Connector를 하나더 생성하여 https, http 모두 사용하자.
- 확인하기
    - curl -I -k --http2 https://localhost:8443/hello
    - curl -I -k --http2 http://localhost:8080/hello
