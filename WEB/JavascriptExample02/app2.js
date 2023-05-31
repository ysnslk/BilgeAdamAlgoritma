
/*
    name
    surname
    age
    username
    password
    interest
    harcamalar
    address nesnesi
        -country
        -city


    toplam harcamaları bulan bir fonksiyon yazalım
*/
let user = {
    name: "Ali",
    surname: "Kaya",
    age: 35,
    username: "berkinY",
    password: "1234",
    interest: ["sinema", "felsefe", "müzik"],
    expenses: [100, 60, 300, 50, 20, 75, 80],
    address: {
        country: "Türkiye",
        city: "Ankara"
    }
}


console.log(user)
console.log(user.address.city)


function sum() {
    let sum = 0;
    user.expenses.forEach(element => {
        sum += element
    });
    return sum;
}
console.log(sum())
console.log("----")

function sum2() {
    let sum = 0;
    for (let i = 0; i < user.expenses.length; i++) {
        sum += user.expenses[i]
    }
    return sum;
}
let toplam = sum2()
console.log(toplam)

const toplamHarcama = function () {
    let sum = 0;
    user.expenses.forEach(element => {
        sum += element
    });
    return sum;
}
console.log(toplamHarcama())


//parametre olarak harcamaları alsın
function sum3(array) {
    let sum = 0;
    array.forEach(x => {
        sum += x
    })
    return sum;
}
console.log(sum3(user.expenses))

const sum4 = () => {
    let sum = 0;
    user.expenses.forEach(x => {
        sum += x
    })
    return sum;
}
console.log("-----------")
console.log(sum4())

const sum5 = () => {
    //reduce metotu kullancaz
    let sum = user.expenses.reduce((x, y) => x + y)
    return sum;
}
console.log(sum5());


//son iki harcamayı getiren func
function sonHarcamalar(array) {
    let harcamalar = array.slice(array.length - 5)
    return harcamalar
}
console.log(sonHarcamalar(user.expenses));

//interest e 1.indexten itibaren 2 tane değer ekleyen fonksiyon

function degerEkle() {
    user.interest.splice(3, 0, "dans", "kitap")
}
degerEkle()
user.interest.forEach(x => console.log(x))
console.log("-----------------");

function degerEkle2(array) {
    user.interest.splice(1, 0, ...array)
}
let gonderilenArray = ["araba", "pc", "konsolOyunlari"]
degerEkle2(gonderilenArray)
user.interest.forEach(x => console.log(x))
//desturcting


let array1 = ["araba", "pc", "konsolOyunlari"]
let array2 = ["masa", "bardak", "telefon"]
let array3 = [...array1, ...array2]
console.log(array3);



//login methodu parametre olarak repassword
//şifreler uyuşuyosa eğer kullanıcının ismini döndürelim
//uyuşmuyosada şifreler uyuşmuyo diye bir ifade döndürelim

function login(password, username) {

    if (username === user.username && password === user.password) {
        return user.name
    } else {
        return "Kullanici adi veya sifrelere Uyusmuyor"
    }
}
console.log(login("12", "ALİKK"))

function login(repassword) {

    if (repassword === user.password) {
        return user.name
    } else {
        return "Sifrelere Uyusmuyor"
    }
}
console.log(login("123"))


//interest ekleyelim maximum toplam 10 interestimiz olabilir
//concat
function addInterests(array) {

    if ((user.interest.length + array.length) < 11) {
        user.interest = user.interest.concat(array)
        return "başarıyla eklendi"
    } else {
        return "eklenmedi "
    }
}

//console.log(addInterests(["yüzme","tiyatro","sörf"]))
console.log(addInterests(["yüzme", "tiyatro"]))
console.log(user.interest)

function addInterestAlternatif(interest) {
    if (user.interest.length < 5) {
        user.interest = user.interest.concat(interest);
        console.log("Eklendi");
    } else {
        console.log("Daha fazla eklenemez");
    }
}
addInterestAlternatif("spor");
addInterestAlternatif("gezginlik");
addInterestAlternatif("yemek");
addInterestAlternatif("okçuluk");
console.log(user.interest)




function loginForm() {
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    if (user.username === username && user.password === password) {
        alert("Giriş Basarili")
    } else {
        alert("Kullanici adi veya sifre hatali")
    }
}


let form = document.querySelector(".loginform")
function loginForm2() {

    if (form.username.value === user.username && form.password.value === user.password) {
        alert("Giriş Basarili")
    } else {
        alert("Kullanici adi veya sifre hatali")
    }
}


