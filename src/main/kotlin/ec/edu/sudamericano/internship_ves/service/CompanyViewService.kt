package ec.edu.sudamericano.internship_ves.service

import ec.edu.sudamericano.internship_ves.entity.CompanyView
import ec.edu.sudamericano.internship_ves.repository.CompanyViewRepository
import org.springframework.stereotype.Service

@Service
class CompanyViewService(private val companyViewRepository: CompanyViewRepository) {

    fun findAll(): List<CompanyView> {
        return companyViewRepository.findAll()
    }

    fun findById(id: Long): CompanyView? {
        return companyViewRepository.findById(id).orElse(null)
    }

    fun createCompany(companyView: CompanyView): CompanyView {
        return companyViewRepository.save(companyView)
    }
}
