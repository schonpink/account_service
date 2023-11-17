package savingsAccounts.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import savingsAccounts.entity.Owner;
import savingsAccounts.exception.EntityNotFoundException;
import savingsAccounts.repository.OwnerRepository;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Owner getOwner(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Owner with id " + id + " not found"));
    }
}