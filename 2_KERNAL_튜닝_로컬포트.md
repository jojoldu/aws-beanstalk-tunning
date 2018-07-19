# 2. Linux Kernal 파라미터 튜닝

지난 시간에 Nginx에 엄청난 양의 에러로그가 발생하면서 부하 테스트가 강제 종료되었습니다!

![nginx_log1](./images/2/nginx_log1.png)

(Nginx log)  
  
이번 시간엔 해당 문제를 해결하는 과정을 진행하겠습니다.

## 2-1. TIME_OUT과 소켓

로그를 자세히 보면 아래와 같습니다.

```bash
2018/07/19 08:03:23 [crit] 2872#0: *338613 connect() to 127.0.0.1:8080 failed (99: Cannot assign requested address) while connecting to upstream, client: 13.125.61.131, server: , request: "GET /availablePoint/1 HTTP/1.1", upstream: "http://127.0.0.1:8080/availablePoint/1", host: "dwlee-beanstalk-performance-tunning.ap-northeast-2.elasticbeanstalk.com"
```

**Nginx가 8080 포트로 연결하는 과정에서 문제가 발생**했다는걸 어렴풋이 알 수 있습니다.  
```bash
ss -s
```

![timeout1](./images/2/timeout1.png)

```bash
netstat -napo | grep -i time_wait
```

![timeout2](./images/2/timeout2.png)

```bash
netstat -napo | grep -ic 8080
```

![timeout3](./images/2/timeout3.png)

## 2-2. Local Port 고갈 문제





![timeout_example1](./images/2/timeout_example1.png)

![timeout_example2](./images/2/timeout_example2.png)

## 2-3. Local Port 범위 증가

```bash
echo "10240 65535" > /proc/sys/net/ipv4/ip_local_port_range
```

## 2-4. Local Port 재사용

```bash
echo "10240 65535" > /proc/sys/net/ipv4/ip_local_port_range
```

## 2-5. Beanstalk Config에 적용


## 참고

TIME_WAIT와 소켓을 배우는데 정말 큰 도움을 준 2개를 소개합니다.

* [CLOSE_WAIT & TIME_WAIT 최종 분석](http://tech.kakao.com/2016/04/21/closewait-timewait/)
* [DevOps와 SE를 위한 리눅스 커널 이야기](https://book.naver.com/bookdb/book_detail.nhn?bid=12343450)