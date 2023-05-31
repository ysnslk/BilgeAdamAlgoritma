
let form = document.querySelector(".quiz-form");
let puan = 0;
const dogrucevaplar = ["B", "B", "A", "A", "C"];


function answer() {
    //console.log(form.soru1.value);
    let textPuan = document.querySelector(".result")
    puan = 0;

    if (form.soru1.value === dogrucevaplar[0]) {
        puan += 20
    }
    if (form.soru2.value === dogrucevaplar[1]) {
        puan += 20
    }
    if (form.soru3.value === dogrucevaplar[2]) {
        puan += 20
    }
    if (form.soru4.value === dogrucevaplar[3]) {
        puan += 20
    }
    if (form.soru5.value === dogrucevaplar[4]) {
        puan += 20
    }
    textPuan.textContent = puan
}

function answer2() {
    //console.log(form.soru1.value);
    let textPuan = document.querySelector(".result")
    puan = 0;

    const cevaplar = [
        form.soru1.value,
        form.soru2.value,
        form.soru3.value,
        form.soru4.value,
        form.soru5.value
    ]

    puan = checkAnswer(cevaplar)
    textPuan.textContent = puan
    textPuan.parentElement.parentElement.classList.remove("d-none")
    scrollTo(0, 0)

    clearInterval(timeInterval)

}
function checkAnswer(cevaplar) {

    cevaplar.map((x, index) => {
        if (x === dogrucevaplar[index]) {
            puan += 20;
        }
    });
    return puan;
}

let time = document.querySelector(".time")
let sn = 0;
let dk = 0;
let saat = 0;

function timer(){
    sn+=1;
    if(sn === 60){
        dk += 1;
        sn = 0;
    }
    if(dk === 60){
        saat +1;
        dk =0;
    }

    time.innerHTML = `Süre : ${saat} saat - ${dk} dk - ${sn} sn `
}

const timeInterval = setInterval(timer, 1000)