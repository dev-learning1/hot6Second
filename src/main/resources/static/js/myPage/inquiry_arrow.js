const $arrowDowns = $(".arrow_down");
const $content = $(".board_content_content");
const $btnToggle = $(".btn_toggle");
let check = false;

$arrowDowns.on("click", function(){
    $(this).parent().parent().children(".board_content_content").toggle('500');
    // $(this).parent().next().removeAttr("style");
    if(check == false){
        $(this).children().attr("src","../../img/main/iconmonstr-caret-up-lined-48.png");
        check = true;
    }else{
        $(this).children().attr("src","../../img/main/iconmonstr-caret-down-lined-48.png");
        check = false;
    }
});