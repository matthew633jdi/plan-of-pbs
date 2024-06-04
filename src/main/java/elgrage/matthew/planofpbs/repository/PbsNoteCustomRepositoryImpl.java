package elgrage.matthew.planofpbs.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import elgrage.matthew.planofpbs.domain.PbsNote;
import elgrage.matthew.planofpbs.request.NoteSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

import static elgrage.matthew.planofpbs.domain.QChristian.christian;
import static elgrage.matthew.planofpbs.domain.QPbsNote.pbsNote;

@RequiredArgsConstructor
public class PbsNoteCustomRepositoryImpl implements PbsNoteCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PbsNote> findByDynamicQuery(NoteSearch search) {
        return jpaQueryFactory
                .selectFrom(pbsNote)
                .leftJoin(pbsNote.christian, christian)
                .fetchJoin()
                .where(keywordEquals(search.getKeyword()), partEq(search.getPassage()), shareEq(search.getIsShared()), userIdEq(search.getUserId()), createdDate(search.getCreatedTime()), modifiedDate(search.getModifiedTime()))
                .fetch();
    }

    private BooleanExpression keywordEquals(String keywordCond) {
        return StringUtils.hasText(keywordCond) ? pbsNote.keyword.eq(keywordCond) : null;
    }

    private BooleanExpression partEq(String part) {
        return StringUtils.hasText(part) ? pbsNote.part.eq(part) : null;
    }

    private BooleanExpression shareEq(Boolean isShared) {
        return isShared != null ? pbsNote.isShared.eq(isShared) : null;
    }

    private BooleanExpression userIdEq(Long userId) {
        return userId != null ? pbsNote.christian.id.eq(userId) : null;
    }

    private BooleanExpression createdDate(LocalDateTime createdDate) {
        // TODO prefix
        return createdDate != null ? pbsNote.createdDate.eq(createdDate) : null;
    }

    private BooleanExpression modifiedDate(LocalDateTime modifiedDate) {
        // TODO prefix
        return modifiedDate != null ? pbsNote.modifiedDate.eq(modifiedDate) : null;
    }
}
