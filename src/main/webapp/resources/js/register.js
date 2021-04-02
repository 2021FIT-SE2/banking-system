$(function () {

    const selector = $('input, select');

    selector.on('focus', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#80bdff');
    });
    selector.on('blur', function () {
        $(this).parent().find('.input-group-text').css('border-color', '#ced4da');
    });

});