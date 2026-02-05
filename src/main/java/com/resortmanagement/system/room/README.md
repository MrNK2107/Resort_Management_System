# Room Domain

Purpose
- Manages rooms, room-types, maintenance requests, housekeeping and room amenities.

Interactions with other domains
- Booking: assigns rooms and room types to reservations.
- Housekeeping: handles housekeeping tasks and maintenance requests.
- Reporting/Billing: room occupancy and maintenance costs flow through reporting and billing.

Key artifacts
- Entities: `Room.java`, `RoomType.java`, `RoomBlock.java`, `RoomAmenity.java`, `HousekeepingTask.java`, `MaintenanceRequest.java`
- Controllers: `RoomController.java`, `RoomTypeController.java`, `RoomBlockController.java`, `RoomAmenityController.java`, `HousekeepingTaskController.java`, `MaintenanceRequestController.java`
- Services: `RoomService.java`, `RoomTypeService.java`, `RoomBlockService.java`, `RoomAmenityService.java`, `HousekeepingTaskService.java`, `MaintenanceRequestService.java`
- Repositories: `RoomRepository.java`, `RoomTypeRepository.java`, `RoomBlockRepository.java`, `RoomAmenityRepository.java`, `HousekeepingTaskRepository.java`, `MaintenanceRequestRepository.java`

Transaction boundaries
- Room assignment and maintenance updates should be transactional at the service level.

Auditing, soft delete, concurrency
- **Auditing**: keep changes to room and maintenance records auditable.
- **Soft delete**: room/amenity metadata can be soft-deleted; historical occupancy data must remain intact.
- **Concurrency**: coordinate room assignment with booking to prevent double-assignments; use locking strategies.

Security roles
- Housekeeping Manager: manage tasks and maintenance
- Frontdesk: assign rooms and handle overrides
- Maintenance: update maintenance request statuses

Design patterns used
- Strategy: maintenance priority and schedules
- Factory/Builder: complex room-block creation and recurring maintenance jobs

Typical workflows
- Create maintenance request -> assign technician -> complete and log costs -> attach any billable charges to reservation folio.
