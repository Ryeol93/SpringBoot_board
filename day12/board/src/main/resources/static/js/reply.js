/*
* reply modules
*
* Javascript 모듈화
*   함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
*   화면 내에서 Javascript 처리를 하다 보면 이벤트 처리와 DOM, Ajax 처리 등
*   복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript를 하나의 모듈처럼 구성하여 사용한다.
*
* */
// console.log("Reply Modules.......");

let replyService = (function(){

    //댓글 추가
    //reply가 객체로 들어온다.
    function add(reply, callback, error) {
        console.log("add reply..........")
        $.ajax({
            type: "POST",
            url: "/replies/new",
            //reply를 제이슨으로 변환
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 목록
    function getList(param, callback, error){
        let bno = param.bno;
        let page = param.page || 1;

        //콜백을 replyPageDTO를 받아준다.
        $.getJSON("/replies/list/" + bno + "/" + page, function(replyPageDTO){
            if(callback){
                callback(replyPageDTO.replyCount, replyPageDTO.list);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        });

        // $.ajax({
        //     type: "GET",
        //     url: "/replies/list/" + bno + "/" + page,
        //     success: function (list) {
        //         if (callback) {
        //             callback(list);
        //         }
        //     },
        //     error: function (xhr, status, er) {
        //         if (error) {
        //             error(er);
        //         }
        //     }
        // });
    }

    //댓글 조회
    function read(rno, callback, error){
        $.get("/replies/" + rno, function(result){
            if(callback){
                callback(result);
            }
        }).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        })
    }

    //댓글 삭제
    function remove(rno, callback, error){
        $.ajax({
            type: "DELETE",
            url: "/replies/" + rno,
            success: function(result) {
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 수정
    function modify(reply, callback, error){
        $.ajax({
            type: "PATCH",
            url: "/replies/" + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 작성 시간(Controller)
    //외부에서 작성된 댓글 시간을 받아온다.
    function getReplyDateByController(replyDate, callback, error){
        $.ajax({
            type: "GET",
            url: "/time", //time이라는 곳으로 이동하고
            data: {replyDate : replyDate}, //replyDate를 넘겨준다
            success: function(date){ //그 결과가 TimeController.java로 넘어간다 //콜백함수가 TimeController에서 넘겨준 time을 받는다.
                if(callback){
                    callback(date);
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }

    //댓글 작성 시간(Javascript)
    function getReplyDateByJavascript(replyDate){
        let today = new Date();
        //댓글 작성한 시간
        let rDate = new Date(replyDate);
        //현재 시간에서 댓글 작성 시간 뺸거
        let gap = today.getTime() - rDate.getTime();

        if(gap < 1000 * 60 * 60 * 24){ //시 분 초
            //작성한 시간이 24이 지나지 않았다면 댓글작성시간을 넣는다.
            let h = rDate.getHours();
            let mm = rDate.getMinutes();
            let s = rDate.getSeconds();

            //앞에 0을 붙여주려면 10보다 작아야한다.
            //join() = Ary 배열에 있는 원소들을 하나의 값으로 만들어준다
            return [(h < 10 ? '0' : '') + h, ':', (mm < 10 ? '0' : '') + mm, ':', (s < 10 ? '0' : '') + s].join("");
        }else{ //년 월 일
            let y = rDate.getFullYear();
            let m = rDate.getMonth() + 1;
            let d = rDate.getDate();

            return [y, '-', (m < 10 ? '0' : '') + m, '-', (d < 10 ? '0' : '') + d].join("");
        }
    }

    return {add: add, getList: getList, read: read, remove: remove, modify: modify, getReplyDateByController: getReplyDateByController, getReplyDateByJavascript: getReplyDateByJavascript}
})();