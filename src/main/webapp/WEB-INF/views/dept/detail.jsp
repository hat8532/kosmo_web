<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html class="h-100">
<head>
    <meta charset="UTF-8">
    <title>부서 상세 정보</title>
    <c:import url="/WEB-INF/views/temp/head.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
        <c:import url="/WEB-INF/views/temp/nav.jsp"></c:import>

        <section class="py-5">
            <div class="container px-5 my-5">
                <div class="text-center mb-5">
                    <h1 class="display-5 fw-bolder mb-0">
                        <span class="text-gradient d-inline">상세정보</span>
                    </h1>
                </div>

                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-8 col-xl-6">
                        <div class="card shadow border-0 rounded-4 mb-5">
                            <div class="card-body p-5">
                                <div class="mb-4">
                                    <h5 class="fw-bolder text-primary">부서 번호</h5>
                                    <p class="lead fw-normal text-muted mb-0">${dto.departmentId}</p>
                                </div>
                                <div class="mb-4">
                                    <h5 class="fw-bolder text-primary">부서 이름</h5>
                                    <p class="lead fw-normal text-muted mb-0">${dto.departmentName}</p>
                                </div>
                                <div class="mb-4">
                                    <h5 class="fw-bolder text-primary">매니저 ID</h5>
                                    <p class="lead fw-normal text-muted mb-0">${dto.managerId}</p>
                                </div>
                                <div class="mb-4">
                                    <h5 class="fw-bolder text-primary">지역 ID</h5>
                                    <p class="lead fw-normal text-muted mb-0">${dto.locationId}</p>
                                </div>

                                <div class="d-flex justify-content-end gap-2">
                                    <a href="./update?departmentId=${dto.departmentId}" class="btn btn-primary px-4">수정</a>
                                    
                                    <form action="./delete" method="get" onsubmit="return confirm('정말 삭제하시겠습니까?');">
                                        <input type="hidden" name="departmentId" value="${dto.departmentId}">
                                        <button class="btn btn-danger px-4">삭제</button>
                                    </form>
                                    
                                    <a href="./list" class="btn btn-outline-secondary px-4">목록으로</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
</body>
</html>