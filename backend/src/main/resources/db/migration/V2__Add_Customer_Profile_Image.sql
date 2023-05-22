ALTER TABLE customer
ADD CONSTRAINT profile_image_id_unique UNIQUE (profile_image_id);

ALTER TABLE customer
ADD CONSTRAINT name_email_unique UNIQUE (name,email);