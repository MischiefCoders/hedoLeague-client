//
//  TablesViewModel.swift
//  iosApp
//
//  Created by USER on 2023/06/03.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

final class TablesViewModel: ObservableObject {
    let sharedEngine: SharedEngine = SharedEngine()

    private var disposeBag = CFlowDisposebag()
    
    @Published
    var tables: [RankInfoUiModel] = []

    func getTables() {
        (sharedEngine.getTables() as! CFlow<NSArray>)
                    .watch { (array: NSArray?) in
                        if let tables = array as? [RankInfo] {
                            self.tables.append(contentsOf: tables.map { rankInfo in
                                return RankInfoUiModel(
                                    position: Int(rankInfo.position),
                                    team: rankInfo.team.name,
                                    playGames: Int(rankInfo.playGames),
                                    won: Int(rankInfo.won),
                                    draw: Int(rankInfo.draw),
                                    lost: Int(rankInfo.lost),
                                    points: Int(rankInfo.points),
                                    goalsFor: Int(rankInfo.goalsFor),
                                    goalsAgainst: Int(rankInfo.goalsAgainst),
                                    goalDifference: Int(rankInfo.goalDifference))
                            })
                        }
                    }.store(in: disposeBag)
    }
                                                
    deinit {
        disposeBag.dispose()
    }
}
