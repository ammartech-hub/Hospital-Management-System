const ctx = document.getElementById("barChart");

if (ctx) {
    new Chart(ctx, {
        type: "bar",
        data: {
            labels: ["Patients", "Doctors", "Appointments"],
            datasets: [{
                label: "Hospital Statistics",
                data: [
                    window.patientCount || 0,
                    window.doctorCount || 0,
                    window.appointmentCount || 0
                ]
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });
}

const pie = document.getElementById("pieChart");

if (pie) {
    new Chart(pie, {
        type: "doughnut",
        data: {
            labels: ["Patients", "Doctors", "Appointments"],
            datasets: [{
                data: [
                    window.patientCount || 0,
                    window.doctorCount || 0,
                    window.appointmentCount || 0
                ]
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });
}