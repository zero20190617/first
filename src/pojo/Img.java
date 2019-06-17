package pojo;

;
    public class Img {
        private Integer id;
        private String path;
        private String filename;
        private String resourcename;
        private String antistop;
        private String downintegral;
        private String size;
        private String uploadtime;
        private String username;
        private Integer downloads;
        private String description;

        public Img() {
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getDownloads() {
            return downloads;
        }

        public void setDownloads(Integer downloads) {
            this.downloads = downloads;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getResourcename() {
            return resourcename;
        }

        public void setResourcename(String resourcename) {
            this.resourcename = resourcename;
        }

        public String getAntistop() {
            return antistop;
        }

        public void setAntistop(String antistop) {
            this.antistop = antistop;
        }

        public String getDownintegral() {
            return downintegral;
        }

        public void setDownintegral(String downintegral) {
            this.downintegral = downintegral;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getUploadtime() {
            return uploadtime;
        }

        public void setUploadtime(String uploadtime) {
            this.uploadtime = uploadtime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "Img{" +
                    "id=" + id +
                    ", path='" + path + '\'' +
                    ", filename='" + filename + '\'' +
                    ", resourcename='" + resourcename + '\'' +
                    ", antistop='" + antistop + '\'' +
                    ", downintegral='" + downintegral + '\'' +
                    ", size='" + size + '\'' +
                    ", uploadtime='" + uploadtime + '\'' +
                    ", username='" + username + '\'' +
                    ", downloads=" + downloads +
                    '}';
        }
    }

