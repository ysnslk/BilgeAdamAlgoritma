//let , const , var
//const ----> final 

let sayi = 20;
const sayi2 = 5;

sayi = sayi2+5;
console.log(sayi2);

let sayilar = [1,2,3,4,5,6,7,8,9];
console.log(sayilar);

let sayilar2 = new Array();
console.log(sayilar2);

for(let i=0;i<sayilar.length;i++){
    console.log(sayilar[i]);
}

sayilar.array.forEach(sayi => {
    console.log(sayi);
});

sayilar.array.forEach(sayi => {
    console.log(sayi+4);
});

sayilar.forEach(x=>{
    sayilar2.push(x+4);
});
console.log(sayilar2);

//map
sayilar2 = sayilar.map(element => element + "AAABB")
console.log(sayilar2);

sayilar2.push(355);
console.log(sayilar2);

sayilar2.unshift(355);
console.log(sayilar2);

sayilar2.pop();
console.log(sayilar2);

sayilar2.shift();
console.log(sayilar2);

//Splice
sayilar2.splice(0,3);
console.log(sayilar2);

sayilar2.splice(0,3,222,333);
console.log(sayilar2);

//Slice
sayilar2.slice(1);
console.log(sayilar2);

//10dan büyük sayıları farklı bir değişkene alalım
console.log("---------------");
let sayilar4 = sayilar2.filter(sayi --> sayi>10);
console.log(sayilar4);

//48 eşit olan sayıyı döndürelim
let sayi48 = sayilar2.find(sayi => sayi === 48);
console.log(sayi48);

//undifined ve null farkını araştır
//let const var
//=== == farkı

//Değer koşul sağlıyor ise true döner
let sonuc = sayilar2.some(x => x >48);
console.log(sonuc);

//Her biri 30dan büyük olması gerek 
let sonuc2 = sayilar2.every(x => x>30);
console.log(sonuc2);

let tersi = sayilar2.reverse();
console.log(tersi);