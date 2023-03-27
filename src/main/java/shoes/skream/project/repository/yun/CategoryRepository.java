package shoes.skream.project.repository.yun;

import org.springframework.data.jpa.repository.JpaRepository;

import shoes.skream.project.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
	Category findByCategoryId (int categoryId);
}
