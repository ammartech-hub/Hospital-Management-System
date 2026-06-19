// =========================================
// Appointment Management JavaScript
// =========================================

document.addEventListener("DOMContentLoaded", function () {

    // ===============================
    // Search Appointment
    // ===============================

    const search = document.getElementById("searchAppointment");

    if (search) {

        search.addEventListener("keyup", function () {

            const filter = this.value.toLowerCase();

            const rows = document.querySelectorAll("#appointmentTable tr");

            rows.forEach(function (row) {

                const text = row.innerText.toLowerCase();

                row.style.display = text.includes(filter) ? "" : "none";

            });

        });

    }

    // ===============================
    // Delete Confirmation
    // ===============================

    const deleteButtons = document.querySelectorAll(".deleteAppointment");

    deleteButtons.forEach(function (button) {

        button.addEventListener("click", function (e) {

            if (!confirm("Delete this appointment?")) {

                e.preventDefault();

            }

        });

    });

    // ===============================
    // Date Validation
    // ===============================

    const date = document.getElementById("appointmentDate");

    if (date) {

        let today = new Date().toISOString().split("T")[0];

        date.setAttribute("min", today);

    }

    // ===============================
    // Time Validation
    // ===============================

    const time = document.getElementById("appointmentTime");

    if (time) {

        time.addEventListener("change", function () {

            if (this.value < "09:00" || this.value > "18:00") {

                alert("Appointments are available between 9:00 AM and 6:00 PM");

                this.value = "";

            }

        });

    }

    // ===============================
    // Form Validation
    // ===============================

    const form = document.getElementById("appointmentForm");

    if (form) {

        form.addEventListener("submit", function (e) {

            const patientId = document.getElementById("patientId").value;

            const doctorId = document.getElementById("doctorId").value;

            if (patientId === "" || doctorId === "") {

                alert("Patient ID and Doctor ID are required.");

                e.preventDefault();

            }

        });

    }

});