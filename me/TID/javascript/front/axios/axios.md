# axios?

## axios란?

---

* 자바스크립트 에서 사용하는 비동기 호출 방식
* HTTP 메서드를 사용할 수 있다. (GET, POST ...)
* 서버에 요청을 보낼 때 사용

## 시용법
---
```
axios({
    method: "get", //HTTP 통신 방식
    url: "www.server.server", //서버
})
```   

* axios 요청에 대해 사용 방법이 여러가지 있는데 난 다 다른방식인줄 알았는데 아니였다 그냥 본인이 사용하고 싶은 방식을 사용하며 되는거였다.
* json방식 통신으로 예를 들어보자!
* ```
    axios({
        method: "post",
        url: "www.어쩌고.저쩌고",
        headers: "content-type": "application/json"
        data: {
            name: "han",
            job: "FastAndFurious"
        }
    }) 
    ```
* ```
    axios.post({ url, data}) 
    ```

* 위의 방식과 아래 방식은 같은 방식이였다
* 하지만 axio로 보낸 요청은 promise를 반환하는데 .than을 이용해 성공시 실행할 방법을 정해주거나 .catch를 이용해 실패시 어떤 방식으로 실행할지를 정해줘야 한다.
* 비동기 함수이기 때문에 이벤트 루프(?)에 있는 모든 요청이 다 해결되고 난 후 task큐 에서 이벤트 루프로 돌아와 실행된다.

## 변수에 값을 담는 방법

* ```
    axios.post(url,data)
        .then(result => {
            // result 에는 요청에 대한 성공한 응답이 담겨있다.
            // result에 있는 어떤 값을 다른 변수에 담고 싶어도 비동기 
            // 함수의 실행이 가장 늦다는 사실을 생각하면 변수가 
            // 아마 unifined로 나오게 될 것이다.
        })
        .catch(error => {
            // error는 요청한 값이 잘못 왔을 때 실행되는것이 아니다.
            // 요청이 가는 와중에 문제가 있는 경우 실행된다.
            // 원하지 않는 값이 오더라도 일단 통신이 성공적으로 보내진다면 
            // .then으로 보내지게 된다.
        })
* 만약 이 axios를 변수에 담으려고 했는데 불가능 했다.
* ```
    try {
        let a = axios.post(url, data)
        let result = a.data.result
        console.log(result);
    }catch (err) {
        console.error(err)
    }```
* 만약 위와같이 작성한다면 변수에 값을 담을 수 있지만 비동기 함수의 실행 순서를 생각한다면 result는 undifined로 정의될것이다.
* ```
    async function () => {
        try {
            let a = await axios.post(url, data)
            let result = a.data.result
            console.log(result);
        }catch (err) {
            console.error(err)
        }
    }
* 마지막 방법처럼 async await을 이용해 비동기 함수를 동기 시켜 값을 기다리게 한 후 사용하면 잘 되는거 같았다!

* 혹시 틀린부분 있으면 수정하겠습니다.