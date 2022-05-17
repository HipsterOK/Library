package ru.ufanet.library.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.ufanet.library.domain.*
import javax.persistence.Tuple


interface IssuanceRepository: JpaRepository<Issuance, Long> {
    @Query("select frst.cfullname as userFullName, frst.phone as userPhone, scnd.title as bookTitle, scnd.afullname as bookAuthorFullName, scnd.end_date as deliveryDate " +
            "from (select iss.id, cu.surname || ' ' || cu.name || ' ' || cu.patronymic as cfullname, cu.phone as phone from issuance iss " +
                "left join corp_user cu on iss.user_id=cu.id) frst " +
                "inner join (select iss.id, bk.tl as title, bk.fn as afullname, iss.end_date " +
                    "from issuance iss " +
                        "left join book_copy bc on iss.book_copy_id=bc.id " +
                        "left join (select ab.id as id, ab.title as tl, au.surname || ' ' || au.name || ' ' || au.patronymic as fn from abstract_book ab " +
                            "inner join authorship aup on ab.id = aup.paper_book_id inner join author au on aup.author_id=au.id) bk " +
                    "on bc.paper_book_id=bk.id where iss.end_date<NOW()) scnd " +
                "on frst.id=scnd.id order by scnd.end_date asc", nativeQuery = true)
    fun findAllDebtors():List<List<String>>

    fun findAllByUser(user: CorpUser):Iterable<Issuance>
}