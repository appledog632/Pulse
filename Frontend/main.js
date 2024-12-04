// const heart = document.querySelector('.heart_btn');
const header = document.querySelector('#header');
const sidebox = document.querySelector('.side_box')
const variableWidth = document.querySelectorAll('.contents_box .contents')
const delegation = document.querySelector('.contents_box');


function delegationFunc(e){
    let elem = e.target;
    console.log(elem);

    if(elem.matches('[data-name="heartbeat"]')){
        console.log("하트");
    }
    else if(elem.matches('[data-name="bookmark"]')){
        console.log("북마크");
    }
    else if(elem.matches('[data-name="share"]')){
        console.log("공유");
    }
    else if(elem.matches('[data-name="more"]')){
        console.log("더보기");
    }
    elem.classList.toggle('on');
}

function resizeFunc() {
    //console.log(innerWidth);
    console.log("resize!")
    if(pageYOffset >= 10){
        let calWidth = window.innerWidth * 0.5 +185;

        sidebox.style.left = calWidth + "px";
    }

    if(matchMedia('screen and (max-width : 800px)').matches){
        for(let i =0; i<variableWidth.length; i++){
            variableWidth[i].style.width = window.innerWidth + 'px';
        }
    }else {
        for(let i =0; i<variableWidth.length; i++){
            if(window.innerWidth > 600){
                variableWidth[i].removeAttribute('style');
            }
        }
    }
}

function scrollFunc(){
    //console.log(pageYOffset);

    if(pageYOffset >= 10){
        header.classList.add('on');
        sidebox.classList.add('on');

        if(sidebox){
            sidebox.classList.add('on');
        }

        resizeFunc()
    }else{
        header.classList.remove('on');
        sidebox.classList.remove('on');
        
        sidebox.removeAttribute('style');

        if(sidebox){
            sidebox.classList.remove('on')
            sidebox.removeAttribute('style');
        }
    }
}

setTimeout(function(){
    scrollTo(0,0);
}, 100)

window.addEventListener('click', delegationFunc);
window.addEventListener('resize', resizeFunc);
window.addEventListener('scroll', scrollFunc);