//
//  RankInfoUiModel.swift
//  iosApp
//
//  Created by USER on 2023/06/03.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

struct RankInfoUiModel: Hashable {
    var position: Int
    var team: String
    var playGames: Int
    var won: Int
    var draw: Int
    var lost: Int
    var points: Int
    var goalsFor: Int
    var goalsAgainst: Int
    var goalDifference: Int
}
