---
title: Info

---

# CICD

## Why do we need CI/CD


* Business Agility 달성을 위해 Application의 빠르고 지속적인 배포에 대한 요구 증가
* 개발과 운영 조직이 분리
* 배포로 인해 장애 발생 시 운영 조직의 책임 편중
* 배포 주기 길어짐, 배포 한번을 위해 배포 계획 수립 및 검증 작업으로 최소 몇 일 소요됨
* Application의 복잡도 증가
* 관리 대상 서비스/인스턴스 증가


## Goal of Continous Integration & Deploy



Blue/Green 배포 방식과 같이 무중단 배포 및 Roll Back을 지원하는 배포 방식 활용
배포로 인해 장애 발생 시 실행 중인 Application에 영향도 없고 배포 완료 후에도 쉽게 Roll Back 가능
기술적인 한계
신규 배포용으로 새로운 서버, 네트워크, 스토리지 필요
추가적인 리소스에 대한 부담과 준비하기 위한 시간이 오래걸려 비현실적임

