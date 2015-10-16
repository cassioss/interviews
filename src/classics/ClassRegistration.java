package classics;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Cassio
 * @version 1.0
 */
public class ClassRegistration {

    HashMap<String, Class> classMap;

    public Class findClassByCode(String code) {
        return classMap.get(code);
    }

    private class Class {
        String code;
        int capacity, credits;
        HashSet<Student> registeredStudents;
        Instant registrationDeadLine, dropDeadLine;

        public Class(String code, Instant registrationDeadLine, Instant dropDeadline, int capacity, int credits) {
            this.code = code;
            this.credits = credits;
            this.capacity = capacity;
            this.registrationDeadLine = registrationDeadLine;
            this.dropDeadLine = dropDeadline;
            registeredStudents = new HashSet<>();
            classMap.put(code, this);
        }

        public boolean passedDeadline(Instant deadline) {
            return Instant.now().toEpochMilli() > deadline.toEpochMilli();
        }

        public boolean classNotFull() {
            return capacity > registeredStudents.size();
        }

        public void registerStudent(Student s) {
            if (!passedDeadline(registrationDeadLine) && classNotFull())
                registeredStudents.add(s);
        }

        public void dropClass(Student s) {
            if (registeredStudents.contains(s) && !passedDeadline(dropDeadLine))
                registeredStudents.remove(s);
        }


    }

    private class Student {
        String name;
        String studentID;

        public Student(String name, String studentID) {
            this.name = name;
            this.studentID = studentID;
        }
    }

}
