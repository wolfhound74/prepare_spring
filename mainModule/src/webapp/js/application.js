/* Глобальное пространство имен */
var PrepareSpring = {};

/**
 * Обертки для ассинхронных запросов
 */
(function () {

    function ajaxHelper(method, url, data, callback) {
        if (data instanceof Function) {
            callback = data;
            data = {};
        }
        $.ajax({
            'url':url,
            'data':data,
            'success':callback,
            'error':function (xhr, textStatus) {
//                if (console && $.isFunction(console.log)) console.log(textStatus);
//                callback({"errors": [
//                    PrepareSpring.Provider.Messages.ajax[textStatus] ? PrepareSpring.Provider.Messages.ajax[textStatus] : textStatus
//                ]});
            },
            'type':method,
            'dataType':'json',
            'cache':false
        });
    }

    PrepareSpring.getJSON = function (url, data, callback) {
        ajaxHelper('get', url, data, callback);
    };
    PrepareSpring.postJSON = function (url, data, callback) {
        ajaxHelper('post', url, data, callback);
    };
})();