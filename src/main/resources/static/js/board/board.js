/*
/board/boardList.html
*/

let boardService = (function(){
     function add(board, callback, error){
    //     $.ajax({
    //         url: "/board/new",
    //         type: "post",
    //         data: JSON.stringify(board),
    //         contentType: "application/json; charset=utf-8", //data에 JSON 작성 시 반드시 contentType 작성
    //         success: function(result){
    //             if(callback){
    //                 callback(result);
    //             }
    //         },
    //         error: function(a, b, c){
    //             if(error){
    //                 error(a, b, c);
    //             }
    //         }
    //     });
     }
    function getList(callback, error){
        $.ajax({
            url: "/board/boardList/",
            success: function(boards){
                if (callback){
                    callback(boards);
                }
            }
        })
    }
    function read(){}
    function remove(){}
    function modify(){}

    return {add: add, getList: getList, read: read, remove: remove, modify: modify}
})();