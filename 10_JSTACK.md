# 2. jstack으로 쓰레드 덤프하기

자 jstack을 하기전에 먼저 현재 사용자를 변경하겠습니다.  
Spring Boot Application이 ec2-user가 아닌 webapp 사용자로 실행되기 때문입니다.  
  
Beanstalk에서 사용중인 EC2로 접속하신 뒤, 

> 혹시나 Beanstalk에서 사용 중인 EC2를 못찾으신다면 이전에 작성한 [포스팅](http://jojoldu.tistory.com/312)을 참고해보세요.

사용자를 변경합니다.

```bash
sudo -u webapp bash
```

```bash
#!/bin/bash

if [ $# -eq 0 ]; then
    echo >&2 "Usage: jstackSeries <pid> [ <count> [ <delay> ] ]"
    echo >&2 "    Defaults: count = 10, delay = 1 (seconds)"
    exit 1
fi

pid=$1          # required
count=${2:-10}  # defaults to 10 times
delay=${3:-1} # defaults to 1 second

while [ $count -gt 0 ]
do
        FILE_NAME=jstack.$pid.$(date +%H%M%S.%N)
        echo "[Current][Active][Thread]: " > ${FILE_NAME}
        CURRENT_THREAD=$(ps -eLf | grep java | wc -l)
        sed -i sed 's/:/: ${CURRENT_THREAD}/' ${FILE_NAME}
        jstack $pid >> ${FILE_NAME}
        sleep $delay
        let count--
        echo -n "."
done
```

```bash
sh jstackSeries.sh 4573 10 1
```

* ```sh jstackSeries.sh [pid] [요청수] [반복주기]```

* [Eclipse.org](http://wiki.eclipse.org/How_to_report_a_deadlock#jstackSeries_--_jstack_sampling_in_fixed_time_intervals_.28tested_on_Linux.29) 