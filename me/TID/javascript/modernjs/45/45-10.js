const promise = new Promise((resolve, reject) => {
    if(/*비동기 처리 성공 */0){
        resolve('result');
    }else /*(비동기 처리 실패 0)*/{
        reject('failure reason');
    }
})