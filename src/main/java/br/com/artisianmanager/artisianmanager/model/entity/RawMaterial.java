package br.com.artisianmanager.artisianmanager.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RawMaterial {

        @Id
        private String _id;
        private String name;
        private String description;
        private String unit;
        private String registerDate;
        private String updateDate;

        // Getters ans Setters
        public String get_id() {
                return _id;
        }
        public void set_id(String _id) {
                this._id = _id;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getDescription() {
                return description;
        }
        public void setDescription(String description) {
                this.description = description;
        }
        public String getUnit() {
                return unit;
        }
        public void setUnit(String unit) {
                this.unit = unit;
        }
        public String getRegisterDate() {
                return registerDate;
        }
        public void setRegisterDate(String registerDate) {
                this.registerDate = registerDate;
        }
        public String getUpdateDate() {
                return updateDate;
        }
        public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
        }
}