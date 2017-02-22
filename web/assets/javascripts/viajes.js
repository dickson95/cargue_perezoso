/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var input = function (options, wrapper=true) {
    var attr = "";
    var input = "";
    $.each(options, function (k, v) {
        attr += k + '="' + v + '" ';
    });
    input = wrapper ? '<div class="col-md-1"><input ' + attr + '/></div>' : '<input ' + attr + '/>';
    return input;
}
var time = function () {
    return new Date().getTime();
}
$(document).ready(function () {
    /**
     * Añadir los inputs para los días que se indiquen en los días de trabajo
     */
    $("#viaje_dias_trabajo").on("keyup click", function () {
        var dias = parseInt($(this).val());
        var dias_trabajo = $("#dias_trabajo");
        dias_trabajo.empty();
        if (!isNaN(dias)) {
            $.each(new Array(dias), function (i) {
                var name = "num_elemets["+i+"]";
                var options = {
                    "type": "number",
                    "name": name,
                    "data-index": i,
                    "required": "true",
                    "placeholder": "N hoy",
                    "class": "form-group form-control elementos_dia",
                    "min": 1,
                    "max": 100
                };
                dias_trabajo.append(input(options));
            });
        }
    });

    /**
     * Añadir las unidades de peso correspondintes a cada día
     */
    $("#dias_trabajo").on("keyup click", ".elementos_dia", function () {
        var elementos = parseInt($(this).val());
        var index_parent = $(this).data("index");
        var div = $(this).parent("div");
        $(this).nextAll().remove();
        if (!isNaN(elementos)) {
            $.each(new Array(elementos), function (i) {
                var name = "num_elemets[" + index_parent + "]["+i+"]";
                var options = {
                    "type": "number",
                    "name": name,
                    "required": "true",
                    "placeholder": "Peso",
                    "class": "form-group form-control peso_elemento",
                    "min": 1,
                    "max": 100
                };
                div.append(input(options, false));
            });
        }
    });



});



