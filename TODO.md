# Hospital Management System - Implementation Checklist

## Step 1: JDBC & Connection Leak Fix
- [ ] Replace `DatabaseConnection` with safe config-driven connection creation (no `null` return).
- [ ] Update all DAOs to use try-with-resources for `Connection`, `PreparedStatement`, `ResultSet`.

## Step 2: Complete Missing CRUD in Service/DAO
- [ ] Complete `AppointmentService` (list/getById/update/delete/search + dropdown helpers).
- [ ] Complete `BillingService` (list/getById/update/delete + payment status update).
- [ ] Extend `AppointmentDAO` with full CRUD + list/search/join queries.
- [ ] Extend `BillingDAO` with full CRUD + list/getById/update/delete.

## Step 3: Add Missing Controllers
- [ ] Create `AppointmentController` with all required routes + validation.
- [ ] Create `BillingController` with all required routes + validation.
- [ ] Add Search endpoints (either per module or centralized).

## Step 4: Authentication + Session + Logout
- [ ] Implement session handling for login success.
- [ ] Protect `/dashboard` and all CRUD routes.
- [ ] Implement `/logout` route and session invalidation.

## Step 5: Rebuild UI (ERP style)
- [ ] Create shared Thymeleaf fragments (sidebar + topbar) and update all existing templates.
- [ ] Replace `dashboard.html` with Bootstrap 5 ERP layout, icons, animations, and Chart.js.
- [ ] Update `patients.html`, `doctors.html`, `login.html` to use shared layout and have working Edit/Delete links.
- [ ] Add new templates for appointments & billing CRUD.

## Step 6: Fix Template/Route Bugs
- [ ] Ensure every sidebar link routes to a real path.
- [ ] Ensure every Edit/Delete button routes correctly (th:href/action/method).

## Step 7: Dashboard Statistics + Charts
- [ ] Update `DashboardController` to query totals and recent records.
- [ ] Provide Chart.js datasets from controller.

## Step 8: Build & Verify
- [ ] Fix `pom.xml` Java version to be Spring Boot compatible.
- [ ] `mvn clean test` / `mvn -q -DskipTests package`.
- [ ] Manual verification of all CRUD flows.

