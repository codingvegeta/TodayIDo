
const uriComp = 'name=이웅모&job=programmer&teacher';

let enc = encodeURIComponent(uriComp);
console.log(enc);

let dec = decodeURIComponent(enc);
console.log(dec);
