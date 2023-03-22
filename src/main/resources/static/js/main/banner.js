const div = document.querySelector("div.banner");
const btns = document.querySelectorAll(".btn");
const firstDiv = document.createElement("div");
const lastDiv = document.createElement("div");
var count = 0;
var buttonCheck = true;
var numberButtonCheck = true;
var temp = btns[count];


// const bannerDiv = document.querySelector("div.banner div");
// bannerDiv.classList.add("banner_img");

// firstDiv.innerHTML = `<img src="37dbc2c3-73f1-4060-8b55-4b36268356db.png">`;
// div.insertBefore(firstDiv, bannerDiv);

// lastDiv.innerHTML = `<img src="PRGM_Img-Banner_2600x600_.jpg">`;
// div.appendChild(lastDiv);

div.style.transform = "translate(-1300px)";

btns[0].style.background = "#fff";

let inter = setInterval(autoSlide, 2500);

// function autoSlide(){
//     count ++;
//     if(count == 6){
//         count = 0;
//     }
//     div.style.transform = "translate(-" + 90 * count +"vw)"
//     div.style.transition = "transform 0.5s";
// }

function autoSlide(){
    div.style.transition = "transform 0.5s";
    count ++;
    if(count == 3){ // 마지막 배너(3번)
        btns[count - 1].style.background = "#f8f8f8";
        div.style.transform = "translate(-" + 1300 * (count + 1) +"px)"
        count = 0;
        btns[count].style.background = "#fff";
        setTimeout(function(){
            div.style.transition = "transform 0s";
            div.style.transform = "translate(-1300px)";
        }, 500);
    }else{
        btns[count - 1].style.background = "#f8f8f8";
        btns[count].style.background = "#fff";
        div.style.transition = "transform 0.5s";
        div.style.transform = "translate(-" + 1300 * (count + 1) +"px)"
    }
    temp = btns[count];
}


// arrows.forEach(arrow => {
//     arrow.addEventListener("click", function(){
//         let arrowType = arrow.classList[1];
//         if(arrowType == "prev"){
//             count --;
//             if(count == -1){
//                 count = 5;
//             }

//         }else{
//             count ++;
//             if(count == 6){
//                 count = 0;
//             }
//         }

//         div.style.transform = "translate(-" + 90 * count +"vw)"

//     });
// });

// 원하는 번호의 배너로 이동
// btns.forEach((btn, i) => {
//     btn.addEventListener("click", function(){
//         count = i;
//         div.style.transform = "translate(-" + 90 * count +"vw)"
//     });
// });

btns.forEach((btn, i) => {
    btn.addEventListener("click", function(){
        div.style.transition = "transform 0.5s";
        if(numberButtonCheck){
            numberButtonCheck = false;
            clearInterval(inter);
            count = i;
            div.style.transform = "translate(-" + 1300 * (count + 1) +"px)"
            temp.style.background = "#f8f8f8";
            temp = btns[count];
            btns[count].style.background = "#fff";
            inter = setInterval(autoSlide, 2500);
            setTimeout(() => {numberButtonCheck = true}, 500);
        }
    });
});