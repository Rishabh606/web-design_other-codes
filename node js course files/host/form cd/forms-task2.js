/**
 * Created by rishabh on 22-06-2017.
 */
$(form_materialise.html).ready(function() {
    Materialize.updateTextFields();
});
$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
});
$(form_materialise.html).ready(function() {
    $('select').material_select();
});