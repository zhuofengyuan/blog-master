const oauth_server='http://localhost:8442/uac/';
const redirect_uri='http://localhost:8442/view/index';
const client_id='feng';
const client_secret='123456';
const token_storage = localStorage;//sessionStorage


function ajaxSetup() {
    $.ajaxSetup({
        timeout : 30000,
        beforeSend : function(xhr) {
            if(this.url.endsWith('/oauth/token')){
                console.log(1)
                return true;
            }
            if (getAuth() == null){
                window.location.href = '/view/admin/login'
            }
            var auth = getAuth();
            if(auth != null){
                xhr.setRequestHeader("Authorization", auth.token_type + ' ' + auth.access_token);
            } else {
                return false;
            }
            return true;
        },
        complete : function(xhr, ts) {
            if (xhr.status == 401 && xhr.responseJSON.error =='invalid_token') {
                refreshToken();
            }
        }
    });
}

function getAuth(){
    let auth = token_storage.getItem('auth');
    return JSON.parse(auth);
}

function saveAuth(sResponse){
    token_storage.setItem("auth", JSON.stringify(sResponse));
}

function clearAuth(){
    token_storage.removeItem('auth');
}

function logout(){
    token_storage.removeItem('auth');
    window.location.href = oauth_server+"/logout?redirect_uri="+redirect_uri;
}

function fetchToken(){
    let url = window.location.toString();

    var data={
        'grant_type':'password',
        'redirect_uri':redirect_uri
    };
    $.ajax({
        url: oauth_server+"/oauth/token",
        type:"post",
        data:data,
        async: false,
        contentType: 'application/x-www-form-urlencoded',
        beforeSend:function(xhr){
            xhr.setRequestHeader("Authorization", 'Basic ' + Base64.encode(client_id+':'+client_secret));
        },
        success: function (sResponse) {
            saveAuth(sResponse);
            console.log('fetch_token ok: ' + sResponse.access_token+'  expires_in:'+sResponse.expires_in);
            //window.location.href = redirect_uri;
        },
        error:function(a,b,c){
            console.log(a, b, c);
        }
    });
}

function refreshToken(){
    var auth = getAuth();
    var data={
        'client_id': client_id,
        'client_secret': client_secret,
        'grant_type':'refresh_token',
        'refresh_token':auth.refresh_token
    };
    $.ajax({
        url: oauth_server+"/oauth/token",
        type:"post",
        data:data,
        async: false,
        contentType: 'application/x-www-form-urlencoded',
        success: function (sResponse) {
            saveAuth(sResponse);
            console.log('refresh_token ok: ' + sResponse.access_token+'  expires_in:'+sResponse.expires_in);
        },
        error:function(a,b,c){
            if (a.status==400 && a.responseJSON.error=='invalid_grant'){
                console.log('refresh token invalid');
                clearAuth();
            }
        }
    });
}

function checkToken(){
    $.ajax({
        url: oauth_server+"/oauth/check_token",
        type:"get",
        async: false,
        data: {'token': getAuth().access_token},
        contentType: 'application/x-www-form-urlencoded',
        success: function (sResponse) {
            console.log('check_token : ' + sResponse);
        },
        error:function(a,b,c){
            console.log(a.responseJSON);
        }
    });
}


$(function() {
    ajaxSetup();
});