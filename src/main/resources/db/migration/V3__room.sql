-- ROOM TYPES
CREATE TABLE room_types (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(100),
    base_rate DOUBLE ,
    bed_type VARCHAR(50),
    area_sq_ft INT,
    amenities_summary TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

-- ROOMS
CREATE TABLE rooms (
    id CHAR(36) PRIMARY KEY,
    room_number VARCHAR(50) UNIQUE NOT NULL,
    floor VARCHAR(20),
    status VARCHAR(30) NOT NULL,
    description TEXT,
    max_occupancy INT,
    room_type_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),

    CONSTRAINT fk_room_type FOREIGN KEY (room_type_id)
        REFERENCES room_types(id)
);

-- ROOM AMENITIES (junction)
CREATE TABLE room_amenities (
    id CHAR(36) PRIMARY KEY,
    room_id CHAR(36) NOT NULL,
    amenity_id CHAR(36) NOT NULL,

    CONSTRAINT uq_room_amenity UNIQUE(room_id, amenity_id)
);

-- ROOM BLOCKS
CREATE TABLE room_blocks (
    id CHAR(36) PRIMARY KEY,
    maintenance_request_id CHAR(36),
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    reason TEXT,
    status VARCHAR(30),
    room_id CHAR(36) NOT NULL,

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    deleted BOOLEAN DEFAULT FALSE,
    deleted_at TIMESTAMP
);

-- MAINTENANCE REQUESTS
CREATE TABLE maintenance_requests (
    id CHAR(36) PRIMARY KEY,
    room_block_id CHAR(36),
    room_or_facility_id CHAR(36) NOT NULL,
    description TEXT,
    severity VARCHAR(30),
    status VARCHAR(30),
    resolved_at TIMESTAMP,
    reported_by CHAR(36),

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    deleted BOOLEAN DEFAULT FALSE,
    deleted_at TIMESTAMP
);

-- HOUSEKEEPING TASKS
CREATE TABLE housekeeping_tasks (
    id CHAR(36) PRIMARY KEY,
    room_id CHAR(36) NOT NULL,
    staff_id CHAR(36),
    scheduled_at TIMESTAMP,
    priority VARCHAR(20),
    status VARCHAR(30),
    notes TEXT,

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    deleted BOOLEAN DEFAULT FALSE,
    deleted_at TIMESTAMP
);
