<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="modal fade" id="modalSave" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Are you sure to save?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-footer d-flex justify-content-md-center">
                <button type="submit" id="btn-yes" class="btn btn-primary">Yes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>

            </div>
        </div>
    </div>
</div>
<script>
    const form = document.querySelector("form");
    const btnYes = document.querySelector("#btn-yes");
    btnYes.addEventListener('click', () => {
        form.submit();
    })
</script>
</body>
</html>
