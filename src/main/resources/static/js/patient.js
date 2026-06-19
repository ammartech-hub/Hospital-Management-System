// ===================================
// Patient Management JavaScript
// ===================================

document.addEventListener("DOMContentLoaded", function () {

    // ===============================
    // Live Search
    // ===============================

    const search = document.getElementById("search");

    if (search) {

        search.addEventListener("keyup", function () {

            const filter = this.value.toLowerCase();

            const rows = document.querySelectorAll("#tableBody tr");

            rows.forEach(function (row) {

                const text = row.innerText.toLowerCase();

                row.style.display = text.includes(filter) ? "" : "none";

            });

        });

    }

    // ===============================
    // Delete Confirmation
    // ===============================

    const deleteButtons = document.querySelectorAll(".delete-btn");

    deleteButtons.forEach(function (button) {

        button.addEventListener("click", function (e) {

            const ok = confirm("Are you sure you want to delete this patient?");

            if (!ok) {

                e.preventDefault();

            }

        });

    });

    // ===============================
    // Phone Validation
    // ===============================

    const phone = document.getElementById("phone");

    if (phone) {

        phone.addEventListener("input", function () {

            this.value = this.value.replace(/[^0-9]/g, "");

            if (this.value.length > 10) {

                this.value = this.value.slice(0, 10);

            }

        });

    }

    // ===============================
    // Age Validation
    // ===============================

    const age = document.getElementById("age");

    if (age) {

        age.addEventListener("input", function () {

            if (this.value < 0) {

                this.value = 0;

            }

            if (this.value > 120) {

                this.value = 120;

            }

        });

    }

    // ===============================
    // Form Validation
    // ===============================

    const form = document.getElementById("patientForm");

    if (form) {

        form.addEventListener("submit", function (e) {

            const patientName = document.getElementById("patientName").value.trim();

            const phoneValue = document.getElementById("phone").value.trim();

            if (patientName === "") {

                alert("Patient Name is required");

                e.preventDefault();

                return;

            }

            if (phoneValue.length !== 10) {

                alert("Phone number must be exactly 10 digits");

                e.preventDefault();

                return;

            }

        });

    }

});