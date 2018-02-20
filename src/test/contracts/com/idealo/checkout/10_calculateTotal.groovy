package com.idealo.checkout
//noinspection GrPackage
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method "POST"
        url "/checkout"
        headers {
            contentType('application/json')
        }
        body([
                [name: "A"],
                [name: "A"],
                [name: "A"],
                [name: "B"]
        ])
    }
    response {
        status 200
        headers {
            header 'Content-Type': 'application/json'
        }
        body([
                "totalAmount": 150.0
        ])
    }
}