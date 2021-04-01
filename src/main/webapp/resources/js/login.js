$(function () {
    'use strict';

    const phoneNumberInput = $("#phone-number-input");
    const verificationCodeInput = $("#verification-code-input");
    const verificationCodeButton = $("#verify-sms-code-button");
    const verificationCodeContainer = $("#verification-code-container");

    const sendSmsCodeButton = $("#send-sms-code-button");

    verificationCodeContainer.hide();
    verificationCodeButton.hide();

    $('.form-control').on('input', function () {
        const $field = $(this).closest('.form-group');
        if (this.value) {
            $field.addClass('field--not-empty');
        } else {
            $field.removeClass('field--not-empty');
        }
    });

    window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('send-sms-code-button', {
        'size': 'invisible',
    });

    sendSmsCodeButton.on("click", (event) => {

        sendSmsCodeButton.html("<i class=\"fa fa-spinner fa-spin\"></i>");

        let phoneNumber = phoneNumberInput.val();
        const appVerifier = window.recaptchaVerifier;

        phoneNumber = "+84" + phoneNumber.substring(1);

        firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
            .then((confirmationResult) => {
                // SMS sent. Prompt user to type the code from the message, then sign the
                // user in with confirmationResult.confirm(code).
                window.confirmationResult = confirmationResult;

                phoneNumberInput.prop("disabled", true);

                verificationCodeContainer.slideToggle("slow", () => {
                    sendSmsCodeButton.hide(() => {
                        verificationCodeButton.slideToggle("slow");
                    });
                });
            }).catch((error) => {
            console.log(error);
        });
    });

    verificationCodeButton.on("click", () => {

        verificationCodeButton.html("<i class=\"fa fa-spinner fa-spin\"></i>");

        const inputVerificationCode = verificationCodeInput.val();

        window.confirmationResult.confirm(inputVerificationCode);

        firebase.auth().currentUser.getIdToken().then(token => {
            window.localStorage.setItem("token", token.toString());
        });

        setTimeout(() => {
            window.location.href = "/dashboard";
        }, 1000);
    });
});