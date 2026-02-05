# Support Domain

Purpose
- Manages guest support tickets, feedback and communications (email/SMS) for guest-facing interactions.

Interactions with other domains
- Booking: ticketing related to bookings or stays.
- FNB/Room/Billing: support requests can relate to orders, room issues or billing disputes.
- Reporting: feedback and ticket data for service quality metrics.

Key artifacts
- Entities: `HelpTicket.java`, `FeedbackReview.java`, `Communication.java`
- Controllers: `HelpTicketController.java`, `FeedbackReviewController.java`, `CommunicationController.java`
- Services: `HelpTicketService.java`, `FeedbackReviewService.java`, `CommunicationService.java`
- Repositories: `HelpTicketRepository.java`, `FeedbackReviewRepository.java`, `CommunicationRepository.java`

Transaction boundaries
- Creating/updating tickets should be transactional; communication sending should be asynchronous where possible.

Auditing, soft delete, concurrency
- **Auditing**: ticket and communication changes should be tracked.
- **Soft delete**: feedback can be archived; do not remove ticket history.
- **Concurrency**: avoid multiple agents working on the same ticket with optimistic locking or assignment locks.

Security roles
- Support Agent: manage tickets
- Manager: escalate and reassign

Design patterns used
- Template Method: communication templates
- Strategy: channel-specific sending (email vs SMS)

Typical workflows
- Guest raises a ticket -> agent picks up and responds -> send communication notifications -> resolve or escalate.
