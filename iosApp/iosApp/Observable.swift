//
//  Observable.swift
//  iosApp
//
//  Created by USER on 2023/06/03.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

final class Observable<T> {
    typealias Listener = (T) -> Void
    var listener: Listener?
    var value: T {
        didSet {
            listener?(value)
        }
    }
    
    init(_ value: T) {
        self.value = value
    }
    
    func bind(listener: Listener?) {
        self.listener = listener
        listener?(value)
    }
}
