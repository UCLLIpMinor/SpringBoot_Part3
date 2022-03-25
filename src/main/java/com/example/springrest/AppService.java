package com.example.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Patient addPatient(Patient patient) throws ServiceException {
        if (patientRepository.findByEmail(patient.getEmail()) != null){
            throw new ServiceException("add", "email.already.used");
        }
        return patientRepository.save(patient);
    }

    public Iterable<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public void deletePatientWithId(long id) {
        patientRepository.deleteById(id);
    }

    public long countPatients() {
        return patientRepository.findAll().size();
    }

    public Patient addExamination (Examination examination, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new ServiceException("add", "patient not found"));
        patient.addExamination(examination);
        patientRepository.save(patient);
        return patient;
    }

    public Examination getExamination(Long examinationId) {
        return examinationRepository.findById(examinationId).orElseThrow(()->new ServiceException("get", "examination not found"));
    }

    public Patient getPatientOfExamination(Long examinationId) {
        Examination examination = examinationRepository.findById(examinationId).orElseThrow(()->new ServiceException("get", "examination not found"));
        Patient patient = patientRepository.findById(examination.getPatient().getId()).get();
        return patient;
    }

    public void deleteExamination(Long examinationId) {
        Patient patient = getPatientOfExamination(examinationId);
        Examination examination = getExamination(examinationId);
        patient.deleteExamination(examination);
        examinationRepository.delete(examination);
    }

    public List<Examination> findAllExaminations() {
        return examinationRepository.findAll();
    }

    public Doctor addDoctorToPatient(Doctor doctor, long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new ServiceException("add", "patient not found"));
        patient.addDoctor(doctor);
        doctorRepository.save(doctor);
        return doctor;
    }
}
