function checkDate(fechaClase) {
            const currentDate = new Date();
            const classDate = new Date(fechaClase);
            return classDate > currentDate;
        }