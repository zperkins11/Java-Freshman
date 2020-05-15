package scripts.bbuu20_miner.util.worldhopping;

import org.tribot.api.General;
import org.tribot.api2007.WorldHopper;
import scripts.bbuu20_miner.data.PlayerInfo;

public class Worlds {
    public static int getRandomWorld(boolean isMembers) {
        int world = General.random(301, 530);
        while (WorldHopper.isMembers(world) != isMembers) {
            world = General.random(301, 530);
        }
        return world;
    }
    public static boolean canJoin500() {
        return Stats.getTotalLevel() >= 500;
    }
    public static boolean canJoin750() {
        return Stats.getTotalLevel() >= 750;
    }
    public static boolean canJoin1250() {
        return Stats.getTotalLevel() >= 1250;
    }
    public static boolean canJoin1500() {
        return Stats.getTotalLevel() >= 1500;
    }
    public static boolean canJoin1750() {
        return Stats.getTotalLevel() >= 1750;
    }
    public static boolean canJoin2000() {
        return Stats.getTotalLevel() >= 2000;
    }
    public static boolean canJoin2200() {
        return Stats.getTotalLevel() >= 2200;
    }
    public static boolean canHopToWorld(int worldNumber) {
        if (PlayerInfo.INSTANCE.isMembers()) {
            if (canJoin1250()) {
                switch (worldNumber) {
                    case 353:
                    case 364:
                    case 429:
                    case 447:
                    case 529:
                        return true;
                }
            }
            if (canJoin1500()) {
                switch (worldNumber) {
                    case 366:
                    case 416:
                    case 420:
                    case 448:
                    case 528:
                        return true;
                }
            }
            if (canJoin1750()) {
                switch (worldNumber) {
                    case 373:
                    case 391:
                    case 449:
                    case 467:
                        return true;
                }
            }
            if (canJoin2000()) {
                switch (worldNumber) {
                    case 349:
                    case 361:
                    case 396:
                    case 428:
                    case 527:
                        return true;
                }
            }
            if (canJoin2200()) {
                switch (worldNumber) {
                    case 415:
                    case 450:
                    case 526:
                        return true;
                }
            }
            switch (worldNumber) {
                case 302:
                case 303:
                case 304:
                case 305:
                case 306:
                case 307:
                case 309:
                case 310:
                case 311:
                case 312:
                case 313:
                case 314:
                case 315:
                case 317:
                case 318:
                case 319:
                case 320:
                case 321:
                case 322:
                case 323:
                case 327:
                case 328:
                case 329:
                case 330:
                case 331:
                case 332:
                case 333:
                case 334:
                case 336:
                case 338:
                case 339:
                case 340:
                case 341:
                case 342:
                case 343:
                case 344:
                case 346:
                case 347:
                case 348:
                case 350:
                case 351:
                case 352:
                case 354:
                case 355:
                case 356:
                case 357:
                case 358:
                case 359:
                case 360:
                case 362:
                case 365:
                case 367:
                case 368:
                case 369:
                case 370:
                case 374:
                case 375:
                case 376:
                case 377:
                case 378:
                case 386:
                case 387:
                case 388:
                case 389:
                case 390:
                case 395:
                case 421:
                case 422:
                case 424:
                case 444:
                case 445:
                case 465:
                case 466:
                case 491:
                case 492:
                case 493:
                case 494:
                case 495:
                case 496:
                case 513:
                case 514:
                case 515:
                case 516:
                case 517:
                case 518:
                case 519:
                case 520:
                case 521:
                case 522:
                case 523:
                case 524:
                case 525:
                    return true;
            }
        }
        switch (worldNumber) {
            case 301:
            case 308:
            case 316:
            case 326:
            case 335:
            case 379:
            case 380:
            case 382:
            case 383:
            case 384:
            case 393:
            case 394:
            case 397:
            case 398:
            case 399:
            case 417:
            case 418:
            case 425:
            case 426:
            case 430:
            case 431:
            case 433:
            case 434:
            case 435:
            case 436:
            case 437:
            case 438:
            case 439:
            case 440:
            case 451:
            case 452:
            case 453:
            case 454:
            case 455:
            case 456:
            case 457:
            case 458:
            case 459:
            case 469:
            case 470:
            case 471:
            case 472:
            case 473:
            case 474:
            case 475:
            case 476:
            case 497:
            case 498:
            case 499:
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
                return true;
        }
        if (canJoin500()) {
            switch (worldNumber) {
                case 381:
                case 413:
                case 419:
                case 427:
                case 468:
                    return true;
            }
        }
        if (canJoin750()) {
            switch (worldNumber) {
                case 372:
                case 385:
                case 414:
                case 432:
                case 530:
                    return true;
            }
        }
        return false;
    }
}