# 2. Linux Kernal 파라미터 튜닝

![nginx_log1](./images/2/nginx_log1.png)

## 2-1. Local Port 고갈

```bash
echo "10240 65535" > /proc/sys/net/ipv4/ip_local_port_range
```

## 2-2. reuse

