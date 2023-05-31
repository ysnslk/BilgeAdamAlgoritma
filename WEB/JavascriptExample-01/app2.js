
/**
 * Name
 * Surname
 * Age
 * Username
 * Password
 * Interest
 * Harcamalar
 * Adres(Nesne)
 *     -Country
 *     -City
 * 
 * toplam harcamaları bulan bi fonksiyon yazalım
 */

let user = {
    name : 'Yasin',
    surname : 'Solak',
    age : 26,
    username : "Ysnslk",
    password : "123",
    interest : ["Tarih","Müzik","Spor"],
    expenses : [100,60,300,50,20],
    adress : {
        country : "Türkiye",
        city : "Eskişehir"
    }
};

console.log(user);
console.log(user.adress.city);

function sumExpenses() {
    let sum = 0;
    user.expenses.forEach(element => {
        sum += element;
    });
    return sum;
}

console.log(sumExpenses());

//Parametre olarak harcamaları alsın

function sumExpenses2(harcama) {
    let sum = 0;
    harcama.forEach(element => {
        sum += element;
    });
    return sum;
}

console.log(sumExpenses2(user.expenses));

const sum4 = () => {
    let sum = 0;
    user.expenses.forEach(x => {
        sum += x;
    })
    return sum;
}

console.log(sum4());

const sum5 = () => {
    //reduce metotu kullancaz
    let sum = user.expenses.reduce((x,y) => x + y);
    return sum;
}
console.log(sum5());

//Son iki harcamayı getiren func

function sonHarcamalar(array){
    let harcamalar = user.expenses.slice(array.lenght - 2);
    return harcamalar;
}
console.log(sonHarcamalar(user.expenses));

function degerEkle(){
    user.interest.splice(1,0,"dans","kitap");
}
degerEkle();
user.interest.forEach(x=> console.log(x));

function degerEkle2(array){
    user.interest.splice(1,0,...array);
}
let gonderlienArray = ["araba","pc","konsol"];
degerEkle2(gonderlienArray);
user.interest.forEach(x=> console.log(x));

let gonderlienArray1 = ["araba","pc","konsol"];
let gonderlienArray2 = ["masa","bardak","telefon"];
let array3 = [...gonderlienArray1,...gonderlienArray2];
degerEkle2(array3);
user.interest.forEach(x=> console.log(x));

//Login metodu

function login(repassword){
    if (user.password === repassword ){
        console.log(user.name);
    }else{
        console.log("Şifreler Uyuşmuyor");
    }
}

login("123");

function addInterest(array){
    if(user.interest.length+array.lenght >11){
        user.interest.concat(array);
        return "Başarıyla Eklendi";
    }else{
        return "Eklenmedi";
    }
}

console.log(addInterest(["yüzme","tiyatro"]));
console.log(user.interest);

