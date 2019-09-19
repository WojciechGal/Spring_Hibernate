package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PublisherService {

//    private PublisherDao publisherDao;
//
//    @Autowired
//    public PublisherService(PublisherDao publisherDao) {
//        this.publisherDao = publisherDao;
//    }
//
//    public void savePublisher(Publisher publisher) {
//        publisherDao.savePublisher(publisher);
//    }
//
//    public void updatePublisher(Publisher publisher) {
//        publisherDao.updatePublisher(publisher);
//    }
//
//    public Publisher findPublisher(Long id) {
//        return publisherDao.findPublisher(id);
//    }
//
//    public void deletePublisher(Long id) {
//        publisherDao.deletePublisher(id);
//    }
//
//
//
//
//
//
//
//    //Z DRUGIEGO DNIA
//    public List<Publisher> findAll() {
//        return publisherDao.findAll();
//    }







    ///////////////PODMIANKA 4 DZIEN////////////////

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
       this.publisherRepository = publisherRepository;
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Publisher findPublisher(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }


    //Z DRUGIEGO DNIA
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }


    public Publisher findByRegon(String regon) {
        return publisherRepository.findByRegon(regon);
    }

    public Publisher findByNip(String nip) {
        return publisherRepository.findByNip(nip);
    }
}
